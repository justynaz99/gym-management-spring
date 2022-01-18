package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.model.ActivityPositionInSchedule;
import com.gymmanagement.gymmanagement.model.Enrollment;
import com.gymmanagement.gymmanagement.model.User;
import com.gymmanagement.gymmanagement.service.ActivityPositionInScheduleService;
import com.gymmanagement.gymmanagement.service.EnrollmentService;
import com.gymmanagement.gymmanagement.service.UserService;
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

    @Autowired
    UserService userService;

    /**
     *
     * @param enrollment to save to sign up for position in schedule
     * @return object with info about saved enrollment and status code
     */
    @PostMapping("/api/enrollment/sign_up")
    public ResponseEntity<?> signUpForActivity(@RequestBody Enrollment enrollment) {
        return new ResponseEntity<>(enrollmentService.signUpForActivity(enrollment), HttpStatus.CREATED);
    }

    /**
     *
     * @param id of user whose enrollments we want to get
     * @return object with info about this enrollments and status code
     */
    @GetMapping("/api/enrollment/{id}/all_by_user")
    public ResponseEntity<?> findAllByIdUser(@PathVariable int id) {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(enrollmentService.findAllByUser(user), HttpStatus.OK);
    }

    /**
     *
     * @param id of enrollment to delete
     * @return object with id of deleted enrollment and status code
     */
    @DeleteMapping("api/enrollment/{id}/delete")
    public ResponseEntity<?> deleteByIdEnrollment(@PathVariable int id) {
        enrollmentService.deleteByIdEnrollment(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    /**
     *
     * @param id of enrollment to get
     * @return object with info about this enrollment
     */
    @GetMapping("/api/enrollment/{id}")
    public ResponseEntity<?> findByIdEnrollment(@PathVariable int id) {
        return ResponseEntity.ok(enrollmentService.findByIdEnrollment(id));
    }

    /**
     *
     * @param id of position for which enrollments we want
     * @return object with info about this enrollments and status code
     */
    @GetMapping("/api/enrollment/{id}/all_by_position")
    public ResponseEntity<?> findAllByPosition(@PathVariable int id) {
        ActivityPositionInSchedule position = scheduleService.findPositionById(id);
        return new ResponseEntity<>(enrollmentService.findAllByPosition(position), HttpStatus.OK);
    }

    /**
     *
     * @param id_position of position which enrollment refers to
     * @param id_user of user which enrollment refers to
     * @return object with info about this position
     */
    @GetMapping("/api/enrollment/{id_position}/{id_user}")
    public ResponseEntity<?> findByPositionAndIdUser(@PathVariable int id_position, @PathVariable int id_user) {
        User user = userService.findUserById(id_user);
        ActivityPositionInSchedule position = scheduleService.findPositionById(id_position);
        return ResponseEntity.ok(enrollmentService.findByPositionAndUser(position, user));
    }
}
