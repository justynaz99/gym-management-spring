package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.Activity;

import java.util.List;

public interface ActivityService {

    List<Activity> findAllActivities();

    Activity saveActivity(Activity activity);

    Activity findActivityById(int id);

    void deleteActivity(int id);
}
