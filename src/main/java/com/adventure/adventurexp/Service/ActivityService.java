package com.adventure.adventurexp.Service;

import com.adventure.adventurexp.Entity.Activity;
import com.adventure.adventurexp.Repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    // Dependencies
    private final ActivityRepository activityRepo;

    @Autowired
    public ActivityService(ActivityRepository activityRepo) {
        this.activityRepo = activityRepo;
    }

    public List<Activity> getAllActivities ()
    {
        List<Activity> activityList = activityRepo.findAll();
        return activityList;
    }

    public Activity getActivityById(Long id) {
        return activityRepo.findById(id).get();
    }

    public Activity createActivity(Activity activity) {
        return activityRepo.save(activity);
    }

    public void deleteActivity(Long id) {
        Long count = activityRepo.countById(id);
        activityRepo.deleteById(id);
    }
}
