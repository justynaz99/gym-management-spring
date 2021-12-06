package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.model.ActivityPositionInSchedule;
import com.gymmanagement.gymmanagement.model.Enrollment;
import com.gymmanagement.gymmanagement.service.ActivityPositionInScheduleService;
import com.gymmanagement.gymmanagement.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class EnrollmentController {

    @Autowired
    EnrollmentService enrollmentService;

    @Autowired
    ActivityPositionInScheduleService scheduleService;

    @PostMapping("/api/enrollment/sign_up")
    public ResponseEntity<?> signUpForActivity(@RequestBody Enrollment enrollment) {
        return new ResponseEntity<>(enrollmentService.signUpForActivity(enrollment), HttpStatus.CREATED);
    }

    @GetMapping("/api/enrollment/{id}/all_by_user")
    public ResponseEntity<?> findAllByIdUser(@PathVariable int id) {
        return new ResponseEntity<>(enrollmentService.findAllByIdUser(id), HttpStatus.OK);
    }

    @DeleteMapping("api/enrollment/{id}/delete")
    public ResponseEntity<?> deleteByIdEnrollment(@PathVariable int id) {
        enrollmentService.deleteByIdEnrollment(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/api/enrollment/{id}")
    public ResponseEntity<?> findByIdEnrollment(@PathVariable int id) {
        return ResponseEntity.ok(enrollmentService.findByIdEnrollment(id));
    }

    @GetMapping("/api/enrollment/{id}/all_by_position")
    public ResponseEntity<?> findAllByPosition(@PathVariable int id) {
        ActivityPositionInSchedule position = scheduleService.findPositionById(id);
        return new ResponseEntity<>(enrollmentService.findAllByPosition(position), HttpStatus.OK);
    }

    @GetMapping("/api/enrollment/{id_position}/{id_user}")
    public ResponseEntity<?> findByPositionAndIdUser(@PathVariable int id_position, @PathVariable int id_user) {
        ActivityPositionInSchedule position = scheduleService.findPositionById(id_position);
        return ResponseEntity.ok(enrollmentService.findByPositionAndIdUser(position, id_user));
    }
}
