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

    /**
     *
     * @return all records from ActivityPositionInScheduleTable
     */
    @Override
    public List<ActivityPositionInSchedule> findAllPositions() {
        return activityPositionInScheduleRepository.findAll();
    }

    /**
     *
     * @param position to save
     * @return saved position
     */
    @Override
    public ActivityPositionInSchedule savePosition(ActivityPositionInSchedule position) {
        return activityPositionInScheduleRepository.save(position);
    }

    /**
     *
     * @param id of position to find
     * @return position with id from param
     */
    @Override
    public ActivityPositionInSchedule findPositionById(int id) {
        return activityPositionInScheduleRepository.findById(id).orElse(null);
    }

    /**
     *
     * @param id of position to delete
     */
    @Override
    public void deletePosition(int id) {
        activityPositionInScheduleRepository.deleteById(id);
    }

    /**
     *
     * @param date for which we want get positions
     * @return all positions for this date in order from the earlier start time
     */
    @Override
    public List<ActivityPositionInSchedule> findAllPositionsByDate(Date date) {
        return activityPositionInScheduleRepository.findAllByDateOrderByStartTimeAsc(date);
    }

    /**
     *
     * @param id of activity for which we want to find positions, f.ex. all positions in schedule which are crossfit classes
     * @return all positions from schedule with this activity
     */
    @Override
    public List<ActivityPositionInSchedule> findAllPositionsByIdActivity(int id) {
        return activityPositionInScheduleRepository.findAllByActivity_IdActivity(id);
    }

    /**
     * method deletes all positions from schedule which are older tha date in param
     * @param date
     */
    @Override
    public void deleteAllByDateLessThanEqual(Date date) {
        activityPositionInScheduleRepository.deleteAllByDateLessThanEqual(date);
    }
}
