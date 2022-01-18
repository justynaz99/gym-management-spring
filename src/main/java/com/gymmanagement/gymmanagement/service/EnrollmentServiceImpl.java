package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.ActivityPositionInSchedule;
import com.gymmanagement.gymmanagement.model.Enrollment;
import com.gymmanagement.gymmanagement.model.User;
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

    /**
     *
     * @param enrollment to create
     * @return created enrollment
     */
    @Override
    public Enrollment signUpForActivity(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    /**
     *
     * @param user whose enrollment we want to get
     * @return enrollments of user from param
     */
    @Override
    public List<Enrollment> findAllByUser(User user) {
        return enrollmentRepository.findAllByUser(user);
    }

    /**
     *
     * @param position from schedule for which enrollment we want to get
     * @return all enrollments for position from param
     */
    @Override
    public List<Enrollment> findAllByPosition(ActivityPositionInSchedule position) {
        return enrollmentRepository.findAllByPosition(position);
    }

    /**
     *
     * @param user whose enrollments will be deleted
     */
    @Override
    public void deleteAllByUser(User user) {
        enrollmentRepository.deleteAllByUser(user);
    }

    /**
     *
     * @param id of enrollment to delete
     */
    @Override
    public void deleteByIdEnrollment(int id) {
        enrollmentRepository.deleteByIdEnrollment(id);
    }

    /**
     *
     * @param id of enrollment to get
     * @return enrollment with id from param
     */
    @Override
    public Enrollment findByIdEnrollment(int id) {
        return enrollmentRepository.findByIdEnrollment(id);
    }

    /**
     *
     * @param position from schedule for which enrollment we want to get
     * @param user whose enrollment we want to get
     * @return
     */
    @Override
    public Enrollment findByPositionAndUser(ActivityPositionInSchedule position, User user) {
        return enrollmentRepository.findByPositionAndUser(position, user);
    }

    /**
     * deletes all enrollments with date from param
     * @param date
     */
    @Override
    public void deleteByPosition_Date(Date date) {
        enrollmentRepository.deleteByPosition_Date(date);
    }
}
