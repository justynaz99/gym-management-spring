package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.ActivityPositionInSchedule;
import com.gymmanagement.gymmanagement.repository.ActivityPositionInScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ActivityPositionInScheduleServiceImpl implements ActivityPositionInScheduleService {

    @Autowired
    ActivityPositionInScheduleRepository activityPositionInScheduleRepository;

    @Override
    public List<ActivityPositionInSchedule> findAllPositions() {
        return activityPositionInScheduleRepository.findAll();
    }

    @Override
    public ActivityPositionInSchedule savePosition(ActivityPositionInSchedule position) {
        return activityPositionInScheduleRepository.save(position);
    }

    @Override
    public ActivityPositionInSchedule findPositionById(int id) {
        return activityPositionInScheduleRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePosition(int id) {
        activityPositionInScheduleRepository.deleteById(id);
    }

    @Override
    public List<ActivityPositionInSchedule> findAllPositionsByDate(Date date) {
        return activityPositionInScheduleRepository.findAllByDateEquals(date);
    }

    @Override
    public List<ActivityPositionInSchedule> findPositionsByIdActivity(int id) {
        return activityPositionInScheduleRepository.findByActivity_IdActivity(id);
    }
}
