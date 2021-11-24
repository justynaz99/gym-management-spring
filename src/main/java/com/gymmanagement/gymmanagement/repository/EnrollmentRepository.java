package com.gymmanagement.gymmanagement.repository;

import com.gymmanagement.gymmanagement.model.ActivityPositionInSchedule;
import com.gymmanagement.gymmanagement.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

    List<Enrollment> findAllByIdUser(int id);

    List<Enrollment> findAllByPosition(ActivityPositionInSchedule position);

    void deleteAllByIdUser(int id);
}
