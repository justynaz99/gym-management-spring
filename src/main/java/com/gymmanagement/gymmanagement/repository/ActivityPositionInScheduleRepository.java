package com.gymmanagement.gymmanagement.repository;

import com.gymmanagement.gymmanagement.model.ActivityPositionInSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ActivityPositionInScheduleRepository extends JpaRepository<ActivityPositionInSchedule, Integer> {

    List<ActivityPositionInSchedule> findAllByDateOrderByStartTimeAsc(Date date);

    List<ActivityPositionInSchedule> findAllByActivity_IdActivity(int id);

    ActivityPositionInSchedule findByIdPosition(int id);

    void deleteAllByDateLessThanEqual(Date date);


}
