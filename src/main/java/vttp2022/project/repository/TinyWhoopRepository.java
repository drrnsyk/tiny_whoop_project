package vttp2022.project.repository;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp2022.project.model.Lap;
import vttp2022.project.model.Pilot;
import vttp2022.project.model.RaceCourse;

import static vttp2022.project.repository.Queries.*;

@Repository
public class TinywhoopRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<RaceCourse> getAllRaceCourses() {
        final List<RaceCourse> raceCourses = new LinkedList<>();
        SqlRowSet rs = null;
        rs = jdbcTemplate.queryForRowSet(SQL_SELECT_ALL_RACE_COURSES);
        while (rs.next()) {
            raceCourses.add(RaceCourse.create(rs));
        }
        return raceCourses;
    }

    public boolean insertRaceCourse(RaceCourse rc) {
        return jdbcTemplate.update(SQL_INSERT_RACE_COURSE, rc.getRaceName(), rc.getLaps().toString(), new Timestamp(rc.getClosingDate().toDateTime().getMillis()), rc.getOrganizer()) > 0;
        // KeyHolder keyholder = new GeneratedKeyHolder();
        // try {
        //     jdbcTemplate.update(conn -> {
        //         PreparedStatement ps = conn.prepareStatement(SQL_INSERT_RACE_COURSE,
        //                 Statement.RETURN_GENERATED_KEYS);
        //         ps.setString(1, rc.getRaceName());
        //         return ps;
        //     }, keyholder);
        // } catch (Exception e) {
        //     
        // }
        // return rc;
    }

    public RaceCourse getRaceCourseByRaceId(String raceId) {
        final List<RaceCourse> raceCourses = new LinkedList<>();
        SqlRowSet rs = null;
        rs = jdbcTemplate.queryForRowSet(SQL_SELECT_RACE_COURSE_BY_RACEID, raceId);
        while (rs.next()) {
            raceCourses.add(RaceCourse.create(rs));
        }
        return raceCourses.get(0);
    }

    public boolean updateRaceCourseById(RaceCourse rc) {
        // return jdbcTemplate.update(SQL_UPDATE_RACE_COURSE_BY_RACEID, rc.getRaceName(), rc.getLaps(), new Timestamp(rc.getClosingDate().toDateTime().getMillis()), rc.getRaceId()) > 0;
        return jdbcTemplate.update(SQL_UPDATE_RACE_COURSE_BY_RACEID, rc.getRaceName(), rc.getLaps().toString(), rc.getOrganizer(), rc.getRaceId()) > 0;
    }

    public boolean deleteRaceCourseById(Integer raceId) {
        return jdbcTemplate.update(SQL_DELETE_RACE_COURSE_BY_RACEID, raceId) > 0;
    }

    public List<Pilot> getPilotsByRaceId(String raceId) {
        final List<Pilot> pilots = new LinkedList<>();
        SqlRowSet rs = null;
        rs = jdbcTemplate.queryForRowSet(SQL_SELECT_PILOTS_BY_RACE_ID, raceId);
        while (rs.next()) {
            pilots.add(Pilot.create(rs));
        }
        return pilots;
    }

    public boolean insertPilotToPilotsByRaceId(Pilot pilot) {
        return jdbcTemplate.update(SQL_INSERT_PILOT_TO_PILOTS_BY_RACE_ID, pilot.getPilotId(), pilot.getPilotName(), pilot.getPilotDroneName()) > 0;
    }

    public boolean insertPilotToLapsByRaceId(List<String> lapTimings, RaceCourse rc, Pilot pilot) {
        for (int i = 0; i < lapTimings.size(); i++) {
            if (jdbcTemplate.update(SQL_INSERT_PILOT_TO_LAPS_BY_RACE_ID, i+1, rc.getRaceId(), pilot.getPilotId(), lapTimings.get(i)) > 0) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public Pilot getPilotByPilotId(String pilotId) {
        final List<Pilot> pilots = new LinkedList<>();
        SqlRowSet rs = null;
        rs = jdbcTemplate.queryForRowSet(SQL_SELECT_PILOT_BY_PILOT_ID, pilotId);
        while (rs.next()) {
            pilots.add(Pilot.create(rs));
        }
        return pilots.get(0);
    }

    public boolean updatePilotById(Pilot pilot) {
        return jdbcTemplate.update(SQL_UPDATE_PILOT_BY_PILOT_ID, pilot.getPilotName(), pilot.getPilotDroneName(), pilot.getPilotId()) > 0;
    }

    public boolean deletePilotByRaceId(Integer raceId, String pilotId) {
        return jdbcTemplate.update(SQL_DELETE_PILOT_BY_RACE_ID, raceId, pilotId) > 0;
    }

    public List<Lap> getPilotLapTiming(Integer raceId, String pilotId) {
        final List<Lap> lapTimings = new LinkedList<>();
        SqlRowSet rs = null;
        rs = jdbcTemplate.queryForRowSet(SQL_SELECT_PILOT_LAP_TIMINGS, raceId, pilotId);
        while (rs.next()) {
            lapTimings.add(Lap.create(rs));
        }
        return lapTimings;
    }
}
