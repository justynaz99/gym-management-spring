package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.ActivityPositionInSchedule;
import com.gymmanagement.gymmanagement.model.Enrollment;
import com.gymmanagement.gymmanagement.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class EnrollmentServiceImpl implements EnrollmentService {


    @Autowired
    EnrollmentRepository enrollmentRepository;

    @Autowired
    ActivityPositionInScheduleService scheduleService;

    @Override
    public Enrollment signUpForActivity(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public List<Enrollment> findAllByIdUser(int id) {
        return enrollmentRepository.findAllByIdUser(id);
    }

    @Override
    public List<Enrollment> findAllByPosition(ActivityPositionInSchedule position) {
        return enrollmentRepository.findAllByPosition(position);
    }

    @Override
    public void deleteAllByIdUser(int id) {
        enrollmentRepository.deleteAllByIdUser(id);
    }

    @Override
    public void deleteByIdEnrollment(int id) {
        enrollmentRepository.deleteByIdEnrollment(id);
    }

    @Override
    public Enrollment findByIdEnrollment(int id) {
        return enrollmentRepository.findByIdEnrollment(id);
    }

    @Override
    public Enrollment findByPositionAndIdUser(ActivityPositionInSchedule position, int id) {
        return enrollmentRepository.findByPositionAndIdUser(position, id);
    }

    @Override
    public void deleteByPosition_Date(Date date) {
        enrollmentRepository.deleteByPosition_Date(date);
    }
}
