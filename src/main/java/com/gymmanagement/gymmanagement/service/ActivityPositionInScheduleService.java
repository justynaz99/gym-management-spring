package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.ActivityPositionInSchedule;

import java.util.Date;
import java.util.List;

public interface ActivityPositionInScheduleService {

    List<ActivityPositionInSchedule> findAllPositions();

    ActivityPositionInSchedule savePosition(ActivityPositionInSchedule position);

    ActivityPositionInSchedule findPositionById(int id);

    void deletePosition(int id);

    List<ActivityPositionInSchedule> findAllPositionsByDate(Date date);

    List<ActivityPositionInSchedule> findAllPositionsByIdActivity(int id);

    void deleteAllByDateLessThanEqual(Date date);

}
