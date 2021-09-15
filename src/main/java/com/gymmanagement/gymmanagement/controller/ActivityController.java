package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @GetMapping("/api/activity/all")
    public ResponseEntity<?> findAllActivities() {
        return ResponseEntity.ok(activityService.findAllActivities());
    }

}
