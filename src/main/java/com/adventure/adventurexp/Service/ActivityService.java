package com.adventure.adventurexp.Service;

import com.adventure.adventurexp.Entity.Activity;
import com.adventure.adventurexp.Entity.Customer;
import com.adventure.adventurexp.Repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        return activityRepo.findAll();
    }
//read only is true by default
    public Activity getActivityById(Long id) {
        return activityRepo.findById(id).orElse(null);
    }
//transactional is false by default


    public Activity createActivity(Activity activity) {
        return activityRepo.save(activity);
    }

    public void deleteActivity(Long id) {
        activityRepo.deleteById(id);
    }


    public Activity updateActivity(Long id, Activity newActivity) {
        if(activityRepo.findById(id).isEmpty()) {
            return null;
        }

        return activityRepo.save(newActivity);
    }
    //search by keyword
    public List<Activity> findByKeywordActivity(String keyword) {
        if (keyword != null) {
            return activityRepo.findByKeywordActivity(keyword);
        }
        return activityRepo.findAll();
    }
}
//get image name


