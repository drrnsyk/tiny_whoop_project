package vttp2022.project.controller;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import vttp2022.project.exception.DateException;
import vttp2022.project.model.RaceCourse;
import vttp2022.project.service.TinywhoopService;

@Controller
@RequestMapping("/race-course")
public class TinywhoopController {

    @Autowired
    private TinywhoopService tinywhoopSvc;

    @GetMapping
    public String getAllRaceCourses(@RequestParam String userName, Model model, HttpSession sess) {
        // query the datebase for the list of race courses
        List<RaceCourse> raceCourses = tinywhoopSvc.getAllRaceCourses();
        model.addAttribute("raceCourses", raceCourses);
        sess.setAttribute("userName", userName);
        return "race-course";
    }

    @GetMapping("/add-race-course")
    public String addRaceCourse(Model model, HttpSession sess) {
        String userName = (String) sess.getAttribute("userName");
        model.addAttribute("userName", userName);
        return "add-race-course";
    }
    
    @PostMapping
    public String saveRaceCourse(@RequestBody MultiValueMap<String, String> form, Model model, HttpSession sess) throws DateException {
        RaceCourse rc = new RaceCourse();
        rc.setRaceName(form.getFirst("race_name"));
        rc.setLaps(Integer.parseInt(form.getFirst("laps")));
        System.out.println(">>>>" + form.getFirst("closing_date"));
        rc.setClosingDate(new DateTime(DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime(form.getFirst("closing_date"))));
        //rc.setClosingDate(new DateTime(DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm").parseDateTime(form.getFirst("closing_date"))));
        // html datetime input is as follow 2022-12-16T15:25
        // SQL to joda pattern is as follow 2022-12-31T12:21:35.000+08:00
        tinywhoopSvc.insertRaceCourse(rc);
        List<RaceCourse> raceCourses = tinywhoopSvc.getAllRaceCourses();
        model.addAttribute("raceCourses", raceCourses);
        return "race-course";
    }

}

