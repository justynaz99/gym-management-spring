package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.model.Activity;
import com.gymmanagement.gymmanagement.model.ActivityPositionInSchedule;
import com.gymmanagement.gymmanagement.service.ActivityPositionInScheduleService;
import com.gymmanagement.gymmanagement.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @Autowired
    ActivityPositionInScheduleService scheduleService;

    /**
     * @name findAllActivities
     * @return response object with info about all activities from Activity table
     */
    @GetMapping("/api/activity/all")
    public ResponseEntity<?> findAllActivities() {
        return ResponseEntity.ok(activityService.findAllActivities());
    }

    /**
     *
     * @param activity to save
     * @return object with info about saved activity
     */
    @PostMapping("/api/activity/add")
    public ResponseEntity<?> addActivity(@RequestBody Activity activity) {
        activity.setIdClub(1); //sets id of the only club in Club table bc it cannot be null
        activity.setIdNetwork(1); //sets id of the only network in clubsNetwork table
        return new ResponseEntity<>(activityService.saveActivity(activity), HttpStatus.CREATED);
    }

    /**
     *
     * @param id of activity to edit
     * @param activity to edit
     * @return object with info about edited activity and status code
     */
    @PutMapping("/api/activity/{id}/edit")
    public ResponseEntity<Activity> updateActivity(@PathVariable int id, @RequestBody Activity activity) {
        return new ResponseEntity<>(activityService.saveActivity(activity), HttpStatus.OK);
    }

    /**
     *
     * @param idActivity of activity to get
     * @return object with info about this activity and status code
     */
    @GetMapping("/api/activity/{idActivity}")
    public ResponseEntity<Activity> findActivityById(@PathVariable int idActivity) {
        return new ResponseEntity<>(activityService.findActivityById(idActivity), HttpStatus.OK);
    }

    /**
     *
     * @param id of activity to delete
     * @return object with id of deleted activity and status code
     */
    @DeleteMapping("/api/activity/{id}/delete")
    public ResponseEntity<?> deleteActivity(@PathVariable int id) {
        try {
            List<ActivityPositionInSchedule> positions = scheduleService.findAllPositionsByIdActivity(id);
            for (ActivityPositionInSchedule position: positions) {
                position.setActivity(null); //must set null in position with this activity id before deleting
            }
            activityService.deleteActivity(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
