package com.gymmanagement.gymmanagement.repository;

import com.gymmanagement.gymmanagement.model.ActivityPositionInSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ActivityPositionInScheduleRepository extends JpaRepository<ActivityPositionInSchedule, Integer> {

    List<ActivityPositionInSchedule> findAllByDateEquals(Date date);
}
