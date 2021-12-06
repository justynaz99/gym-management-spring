package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.model.ActivityPositionInSchedule;
import com.gymmanagement.gymmanagement.service.ActivityPositionInScheduleService;
import com.gymmanagement.gymmanagement.service.EnrollmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ActivityPositionInScheduleController {

    @Autowired
    ActivityPositionInScheduleService activityPositionInScheduleService;

    @Autowired
    EnrollmentService enrollmentService;

    @GetMapping("/api/schedule/all")
    public ResponseEntity<?> findAllPositions() {
        return ResponseEntity.ok(activityPositionInScheduleService.findAllPositions());
    }

    @GetMapping("/api/schedule/{date}/all")
    public ResponseEntity<?> findAllPositionsByDate(@PathVariable @DateTimeFormat(pattern = "dd.MM.yyyy") Date date) {
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

//    @Scheduled(cron = "0 0/1 * * * *")
//    public void print() {
//        Date date = new Date();
//        System.out.println(date);
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.add(Calendar.DAY_OF_MONTH, -3);
//        Date dateMinusThree = calendar.getTime();
//        System.out.println(dateMinusThree);
//    }


    @DeleteMapping("/api/schedule/delete")
    @Scheduled(cron = "0 0 1 * * *")
    public void deletePositionByDate() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        Date dateMinusThree = calendar.getTime();
        enrollmentService.deleteByPosition_Date(dateMinusThree);
        activityPositionInScheduleService.deleteAllByDateLessThanEqual(dateMinusThree);
    }

    @PostMapping("/api/schedule/copy")
    @Scheduled(cron = "0 0 1 * * *")
    public void copyAllByDate() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        System.out.println(date);
        List<ActivityPositionInSchedule> positions = activityPositionInScheduleService.findAllPositionsByDate(date);
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        Date datePlusSeven = calendar.getTime();
        java.sql.Date datePlusSevenSql = new java.sql.Date(datePlusSeven.getTime());
        System.out.println(positions);
        for (ActivityPositionInSchedule position: positions) {
            ActivityPositionInSchedule newPosition = new ActivityPositionInSchedule();
            BeanUtils.copyProperties(position, newPosition);
            newPosition.setIdPosition(null);
            newPosition.setDate(datePlusSevenSql);
            activityPositionInScheduleService.savePosition(position);
            activityPositionInScheduleService.savePosition(newPosition);
        }
    }
}
