package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.ActivityPositionInSchedule;
import com.gymmanagement.gymmanagement.model.Enrollment;
import com.gymmanagement.gymmanagement.model.User;

import java.util.Date;
import java.util.List;

public interface EnrollmentService {

    Enrollment signUpForActivity(Enrollment enrollment);

    List<Enrollment> findAllByUser(User user);

    List<Enrollment> findAllByPosition(ActivityPositionInSchedule position);

    void deleteAllByUser(User user);

    void deleteByIdEnrollment(int id);

    Enrollment findByIdEnrollment(int id);

    Enrollment findByPositionAndUser(ActivityPositionInSchedule position, User user);

    void deleteByPosition_Date(Date date);
}
