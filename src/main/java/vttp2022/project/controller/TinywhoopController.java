package vttp2022.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp2022.project.model.RaceCourse;
import vttp2022.project.service.TinywhoopService;

@Controller
@RequestMapping("/racecourse")
public class TinywhoopController {

    @Autowired
    private TinywhoopService tinywhoopSvc;

    @GetMapping
    public String getAllRaceCourses(@RequestParam String userName, Model model) {
        // query the datebase for the list of race courses
        List<RaceCourse> raceCourses = tinywhoopSvc.getAllRaceCourses();
        model.addAttribute("raceCourses", raceCourses);
        model.addAttribute("userName", userName);
        return "racecourse";
    }

}

