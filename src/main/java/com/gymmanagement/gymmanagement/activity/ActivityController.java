package com.gymmanagement.gymmanagement.activity;

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
    public List<ActivityEntity> getAllActivities() {
        return activityRepository.findAll();
    }

}
