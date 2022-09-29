package com.adventure.adventurexp.Controller;

import com.adventure.adventurexp.Entity.Activity;
import com.adventure.adventurexp.Service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ActivityController {

    //Dependencies
    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    //Return all activities
    @GetMapping("/activities")
    public List<Activity> getAllActivities(){
        return activityService.getAllActivities();
    }

    //Create a method that returns a single activity
    @GetMapping("/activities/{id}")
    public ResponseEntity<Activity> getActivityById(@PathVariable("id") Long id){
        Activity activity = activityService.getActivityById(id);
        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

    //Create a activity
    @PostMapping("/activities")
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity){
        Activity newActivity = activityService.createActivity(activity);
        return new ResponseEntity<>(newActivity, HttpStatus.CREATED);
    }

    //Update an activity
    @PostMapping("/edits/{userId}")
    public Activity updateCustomer(@RequestBody Activity newCustomer, @PathVariable final Long userId)
    {
        return activityService.updateActivity(userId, newCustomer);
    }

    //Delete an activity
    @DeleteMapping("/activities/{id}")
    public ResponseEntity<?> deleteActivity(@PathVariable("id") Long id){
        activityService.deleteActivity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}