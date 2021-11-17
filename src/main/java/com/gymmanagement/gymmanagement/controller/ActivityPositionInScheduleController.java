package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.model.ActivityPositionInSchedule;
import com.gymmanagement.gymmanagement.service.ActivityPositionInScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ActivityPositionInScheduleController {

    @Autowired
    ActivityPositionInScheduleService activityPositionInScheduleService;

    @GetMapping("/api/schedule/all")
    public ResponseEntity<?> findAllPositions() {
        return ResponseEntity.ok(activityPositionInScheduleService.findAllPositions());
    }

    @GetMapping("/api/schedule/{date}/all")
    public ResponseEntity<?> findAllPositionsByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return ResponseEntity.ok(activityPositionInScheduleService.findAllPositionsByDate(date));
    }

    @PostMapping("/api/schedule/add")
    public ResponseEntity<?> addPosition(@RequestBody ActivityPositionInSchedule position) {
        return new ResponseEntity<>(activityPositionInScheduleService.savePosition(position), HttpStatus.CREATED);
    }

    @PutMapping("/api/schedule/{id}/edit")
    public ResponseEntity<ActivityPositionInSchedule> updatePosition(@PathVariable int id, @RequestBody ActivityPositionInSchedule position) {
        return new ResponseEntity<>(activityPositionInScheduleService.savePosition(position), HttpStatus.OK);
    }

    @GetMapping("/api/schedule/{id}")
    public ResponseEntity<ActivityPositionInSchedule> findPositionById(@PathVariable int id) {
        return new ResponseEntity<>(activityPositionInScheduleService.findPositionById(id), HttpStatus.OK);
    }

    @DeleteMapping("/api/schedule/{id}/delete")
    public ResponseEntity<?> deletePosition(@PathVariable int id) {
        activityPositionInScheduleService.deletePosition(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
