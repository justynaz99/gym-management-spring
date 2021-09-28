package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.model.Activity;
import com.gymmanagement.gymmanagement.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @GetMapping("/api/activity/all")
    public ResponseEntity<?> findAllActivities() {
        return ResponseEntity.ok(activityService.findAllActivities());
    }

    @PostMapping("/api/activity/add")
    public ResponseEntity<?> addActivity(@RequestBody Activity activity) {
        activity.setIdClub(1);
        activity.setClubIdNetwork(1);
        return new ResponseEntity<>(activityService.saveActivity(activity), HttpStatus.CREATED);
    }

    @PutMapping("/api/activity/{id}/edit")
    public ResponseEntity<Activity> updateActivity(@PathVariable int id, @RequestBody Activity activity) {
        return new ResponseEntity<>(activityService.saveActivity(activity), HttpStatus.OK);
    }

    @GetMapping("/api/activity/{id}")
    public ResponseEntity<Activity> findActivityById(@PathVariable int id) {
        return new ResponseEntity<>(activityService.findActivityById(id), HttpStatus.OK);
    }

    @DeleteMapping("/api/activity/{id}/delete")
    public ResponseEntity<?> deleteActivity(@PathVariable int id) {
        activityService.deleteActivity(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
