package vttp2022.project.service;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vttp2022.project.exception.DateException;
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

        // Create the purchaseOrder
        tinywhoopRepo.insertRaceCourse(rc);
        
        if (rc.getClosingDate().isBefore(DateTime.now()))
            throw new DateException("Closing Date cannot be backdated");
    }

}
