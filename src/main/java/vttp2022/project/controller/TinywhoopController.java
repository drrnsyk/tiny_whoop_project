package vttp2022.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/racecourse")
public class TinywhoopController {

    @GetMapping
    public String getAllRaceCourses(@RequestParam String userName, Model model) {
        model.addAttribute("userName", userName);
        return "racecourse";
    }

}

