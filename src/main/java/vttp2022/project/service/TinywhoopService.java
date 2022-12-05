package vttp2022.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2022.project.model.RaceCourse;
import vttp2022.project.repository.TinywhoopRepository;

@Service
public class TinywhoopService {
    
    @Autowired
    private TinywhoopRepository tinywhoopRepo;

    public List<RaceCourse> getAllRaceCourses() {
        return tinywhoopRepo.getAllRaceCourses();
    }

}
