package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.ActivityPositionInSchedule;
import com.gymmanagement.gymmanagement.model.Enrollment;

import java.util.List;

public interface EnrollmentService {

    Enrollment signUpForActivity(Enrollment enrollment);

    List<Enrollment> findAllByIdUser(int id);

    List<Enrollment> findAllByPosition(ActivityPositionInSchedule position);

    void deleteAllByIdUser(int id);
}
