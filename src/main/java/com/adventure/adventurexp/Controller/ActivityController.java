package com.adventure.adventurexp.Controller;

import com.adventure.adventurexp.Entity.Activity;
import com.adventure.adventurexp.Service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActivityController {

    //Dependencies
    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }
    @GetMapping("/activities")
    public List<Activity> getAllActivities(){
        return activityService.getAllActivities();
    }
    //Create a method that returns a single activity
    @GetMapping("find{id}")
    public ResponseEntity<Activity> getActivityById(@PathVariable("id") int id){
        Activity activity = activityService.getActivityById(id);
        return new ResponseEntity<>(activity, HttpStatus.OK);
    }
    //Create a activity
    @PostMapping("/addActivity")
    public ResponseEntity<Activity> createActivity(Activity activity){
        Activity newActivity = activityService.createActivity(activity);
        return new ResponseEntity<>(newActivity, HttpStatus.CREATED);
    }
    //update a activity
    @PutMapping("/updateActivity")
    public ResponseEntity<Activity> updateActivity(Activity activity){
        Activity updateActivity = activityService.updateActivity(activity);
        return new ResponseEntity<>(updateActivity, HttpStatus.OK);
    }
    //delete a activity
    @DeleteMapping("/deleteActivity{id}")
    public ResponseEntity<?> deleteActivity(@PathVariable("id") int id){
        activityService.deleteActivity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
