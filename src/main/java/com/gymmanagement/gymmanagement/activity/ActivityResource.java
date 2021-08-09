package com.gymmanagement.gymmanagement.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ActivityResource {

    @Autowired
    private ActivityHardcodedService activityService;

    @GetMapping("/activities")
    public List<Activity> getAllActivities() {
        return activityService.findAll();
    }

    @GetMapping("/activities/{id}")
    public Activity getActivity(@PathVariable long id) {
        return activityService.findById(id);
    }

    @DeleteMapping("/activities/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable long id) {
        Activity activity = activityService.deleteById(id);
        if (activity != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/activities/{id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable long id, @RequestBody Activity activity) {
        Activity updatedActivity = activityService.save(activity);
        return new ResponseEntity<Activity>(activity, HttpStatus.OK);
    }

    @PostMapping("/activities")
    public ResponseEntity<Void> createActivity(@PathVariable long id, @RequestBody Activity activity) {
        Activity createdActivity = activityService.save(activity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdActivity.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }



}
