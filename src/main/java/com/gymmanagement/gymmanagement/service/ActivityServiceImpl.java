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

    @Override
    public List<Activity> findAllActivities() {
        return activityRepository.findAll();
    }

    @Override
    public Activity saveActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public Activity findActivityById(int id) {
        return activityRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteActivity(int id) {
        activityRepository.deleteById(id);
    }
}
