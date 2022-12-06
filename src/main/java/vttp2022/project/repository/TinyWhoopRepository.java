package vttp2022.project.repository;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

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
        return jdbcTemplate.update(SQL_INSERT_RACE_COURSE, rc.getRaceName(), rc.getLaps().toString(), new Timestamp(rc.getClosingDate().toDateTime().getMillis())) > 0;
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
}
