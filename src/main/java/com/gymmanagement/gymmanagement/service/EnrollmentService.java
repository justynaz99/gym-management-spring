package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.ActivityPositionInSchedule;
import com.gymmanagement.gymmanagement.model.Enrollment;

import java.util.Date;
import java.util.List;

public interface EnrollmentService {

    Enrollment signUpForActivity(Enrollment enrollment);

    List<Enrollment> findAllByIdUser(int id);

    List<Enrollment> findAllByPosition(ActivityPositionInSchedule position);

    void deleteAllByIdUser(int id);

    void deleteByIdEnrollment(int id);

    Enrollment findByIdEnrollment(int id);

    Enrollment findByPositionAndIdUser(ActivityPositionInSchedule position, int id);

    void deleteByPosition_Date(Date date);
}
