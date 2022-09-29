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

    public List<Activity> getAllActivities() {
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
        activityRepo.deleteById(id);
    }

    public Activity updateActivity(Long id, Activity newActivity) {
        Activity activity = activityRepo.findById(id).get();

        activity.setId(newActivity.getId());
        activity.setName(newActivity.getName());
        activity.setDescription(newActivity.getDescription());

        return activityRepo.save(activity);
    }
}
