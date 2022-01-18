package com.gymmanagement.gymmanagement.repository;

import com.gymmanagement.gymmanagement.model.ActivityPositionInSchedule;
import com.gymmanagement.gymmanagement.model.Enrollment;
import com.gymmanagement.gymmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

    List<Enrollment> findAllByUser(User user);

    List<Enrollment> findAllByPosition(ActivityPositionInSchedule position);

    void deleteAllByUser(User user);

    void deleteByIdEnrollment(int id);

    Enrollment findByIdEnrollment(int id);

    Enrollment findByPositionAndUser(ActivityPositionInSchedule position, User user);

    void deleteByPosition_Date(Date date);

}
