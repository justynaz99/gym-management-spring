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


    /**
     *
     * @return object with info about all records from ActivityPositionInSchedule table
     */
    @GetMapping("/api/schedule/all")
    public ResponseEntity<?> findAllPositions() {
        return ResponseEntity.ok(activityPositionInScheduleService.findAllPositions());
    }

    /**
     *
     * @param date of positions to get
     * @return object with info about all records with this date from ActivityPositionInSchedule table
     */
    @GetMapping("/api/schedule/{date}/all")
    public ResponseEntity<?> findAllPositionsByDate(@PathVariable @DateTimeFormat(pattern = "dd.MM.yyyy") Date date) {
        return ResponseEntity.ok(activityPositionInScheduleService.findAllPositionsByDate(date));
    }


    /**
     *
     * @param position to add
     * @return object with info about added position and status code
     */
    @PostMapping("/api/schedule/add")
    public ResponseEntity<?> addPosition(@RequestBody ActivityPositionInSchedule position) {

        return new ResponseEntity<>(activityPositionInScheduleService.savePosition(position), HttpStatus.CREATED);
    }


    /**
     *
     * @param id of position to edit
     * @param position to edit
     * @return object with info about edited position and status code
     */
    @PutMapping("/api/schedule/{id}/edit")
    public ResponseEntity<ActivityPositionInSchedule> updatePosition(@PathVariable int id, @RequestBody ActivityPositionInSchedule position) {
        return new ResponseEntity<>(activityPositionInScheduleService.savePosition(position), HttpStatus.OK);
    }

    /**
     *
     * @param id of position to get
     * @return object with info about this position
     */
    @GetMapping("/api/schedule/{id}")
    public ResponseEntity<ActivityPositionInSchedule> findPositionById(@PathVariable int id) {
        return ResponseEntity.ok(activityPositionInScheduleService.findPositionById(id));
    }

    /**
     *
     * @param id of position to delete
     * @return object with edited position's id and status code
     */
    @DeleteMapping("/api/schedule/{id}/delete")
    public ResponseEntity<?> deletePosition(@PathVariable int id) {
        activityPositionInScheduleService.deletePosition(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    /**
     * method to delete positions from one week ago day
     * to keep only one week's schedule history and to automatically remove records
     */
    @DeleteMapping("/api/schedule/delete")
    @Scheduled(cron = "0 0 1 * * *")
    public void deletePositionByDate() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        Date dateMinusSeven = calendar.getTime();
        enrollmentService.deleteByPosition_Date(dateMinusSeven); //deletes all enrollments with one week ago date to enable deleting positions
        activityPositionInScheduleService.deleteAllByDateLessThanEqual(dateMinusSeven);
    }

    /**
     * method to copy records from today's schedule to in one week schedule
     * enables automatic schedule creation one week in advance
     * finds all today's positions and copy them with plus seven days date
     */
    @PostMapping("/api/schedule/copy")
    @Scheduled(cron = "0 0 1 * * *")
    public void copyAllByDate() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        System.out.println(date);
        //finds all today's positions
        List<ActivityPositionInSchedule> positions = activityPositionInScheduleService.findAllPositionsByDate(date);
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        Date datePlusSeven = calendar.getTime();
        java.sql.Date datePlusSevenSql = new java.sql.Date(datePlusSeven.getTime());
        System.out.println(positions);
        //loop to copy all today's position and change their date's to plus seven days date and save it
        for (ActivityPositionInSchedule position: positions) {
            ActivityPositionInSchedule newPosition = new ActivityPositionInSchedule();
            BeanUtils.copyProperties(position, newPosition);
            newPosition.setIdPosition(null); //set to null bc it should be generated automatically
            newPosition.setDate(datePlusSevenSql);
            activityPositionInScheduleService.savePosition(position);
            activityPositionInScheduleService.savePosition(newPosition);
        }
    }
}
