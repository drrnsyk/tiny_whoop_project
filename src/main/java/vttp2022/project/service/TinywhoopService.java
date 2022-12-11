package vttp2022.project.service;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vttp2022.project.exception.DateException;
import vttp2022.project.model.Lap;
import vttp2022.project.model.Pilot;
import vttp2022.project.model.RaceCourse;
import vttp2022.project.repository.TinywhoopRepository;

@Service
public class TinywhoopService {
    
    @Autowired
    private TinywhoopRepository tinywhoopRepo;

    public List<RaceCourse> getAllRaceCourses() {
        return tinywhoopRepo.getAllRaceCourses();
    }

    @Transactional(rollbackFor = DateException.class)
    public void insertRaceCourse(RaceCourse rc) throws DateException {
        tinywhoopRepo.insertRaceCourse(rc);
        if (rc.getClosingDate().isBefore(DateTime.now()))
            throw new DateException("Closing Date cannot be backdated");
    }

    public RaceCourse getRaceCourseById(String raceId) {
        return tinywhoopRepo.getRaceCourseByRaceId(raceId);
    }

    public boolean updateRaceCourseById(RaceCourse rc) {
        return tinywhoopRepo.updateRaceCourseById(rc);
    }

    public boolean deleteRaceCourseById(Integer raceId) {
        return tinywhoopRepo.deleteRaceCourseById(raceId);
    }

    public List<Pilot> getPilotsByRaceId(String raceId) {
        return tinywhoopRepo.getPilotsByRaceId(raceId);
    }

    public boolean insertPilotToPilotsByRaceId(Pilot pilot) {
        return tinywhoopRepo.insertPilotToPilotsByRaceId(pilot);
    }

    public boolean insertPilotToLapsByRaceId(List<String> lapTimings, RaceCourse rc, Pilot pilot) {
        return tinywhoopRepo.insertPilotToLapsByRaceId(lapTimings, rc, pilot);    
    }

    public Pilot getPilotByPilotId(String pilotId) {
        return tinywhoopRepo.getPilotByPilotId(pilotId);
    }

    public boolean updatePilotById(Pilot pilot) {
        return tinywhoopRepo.updatePilotById(pilot);
    }

    public boolean deletePilotByRaceId(Integer raceId, String pilotId) {
        return tinywhoopRepo.deletePilotByRaceId(raceId, pilotId);
    }

    public List<Lap> getPilotLapTiming(Integer raceId, String pilotId) {
        return tinywhoopRepo.getPilotLapTiming(raceId, pilotId);
    }

}
