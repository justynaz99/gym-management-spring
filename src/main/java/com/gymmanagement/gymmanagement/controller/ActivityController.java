package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.model.Activity;
import com.gymmanagement.gymmanagement.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ActivityController {

    @Autowired
    ActivityRepository activityRepository;

    @GetMapping("/activities")
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

}
