package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.Activity;
import com.gymmanagement.gymmanagement.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityRepository activityRepository;

    /**
     *
     * @return all records from Activity table
     */
    @Override
    public List<Activity> findAllActivities() {
        return activityRepository.findAll();
    }

    /**
     *
     * @param activity to save
     * @return saved activity
     */
    @Override
    public Activity saveActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    /**
     *
     * @param id of activity to get
     * @return activity with id from param or null
     */
    @Override
    public Activity findActivityById(int id) {
        return activityRepository.findById(id).orElse(null);
    }

    /**
     *
     * @param id of activity to delete
     */
    @Override
    public void deleteActivity(int id) {
        activityRepository.deleteById(id);
    }
}
