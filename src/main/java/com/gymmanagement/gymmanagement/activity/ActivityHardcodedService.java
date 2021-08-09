package com.gymmanagement.gymmanagement.activity;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityHardcodedService {

    private static List<Activity> activities = new ArrayList<>();
    private static int idCounter = 0;

    static {
        activities.add(new Activity(++idCounter, "zajęcia1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));
        activities.add(new Activity(++idCounter, "zajęcia2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));
        activities.add(new Activity(++idCounter, "zajęcia3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));
    }

    public List<Activity> findAll() {
        return activities;
    }

    public Activity save(Activity activity) {
        if (activity.getId() == -1 || activity.getId() == 0) {
            activity.setId(++idCounter);
        } else {
            deleteById(activity.getId());
        }
        activities.add(activity);
        return activity;
    }

    public Activity deleteById(long id) {
        Activity activity = findById(id);
        if (activity == null)
            return null;
        if (activities.remove(activity))
            return activity;
        return null;
    }

    public Activity findById(long id) {
        for (Activity activity: activities) {
            if (activity.getId() == id) {
                return activity;
            }
        }
        return null;
    }
}
