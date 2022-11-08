package com.adventure.adventurexp.Controller;

import com.adventure.adventurexp.Entity.Activity;
import com.adventure.adventurexp.Entity.Booking;
import com.adventure.adventurexp.Entity.Customer;
import com.adventure.adventurexp.Service.ActivityService;
import com.adventure.adventurexp.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ActivityController {

    //Dependencies
    private final ActivityService activityService;

    private final BookingService bookingService;

    @Autowired
    public ActivityController(ActivityService activityService, BookingService bookingService) {
        this.activityService = activityService;
        this.bookingService = bookingService;
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
        return new ResponseEntity<>(activity, HttpStatus.OK);/**/
    }

    /*@GetMapping("/activities/{id}/bookings")
    public List<Booking> getBookingsByActivity(@PathVariable("id") Long id) {
        return activityService.getActivityById(id).getBookings().stream().toList();
    }
*/
    @GetMapping("/activities/{id}/bookings")
    public List<Booking> getBookingsByActivity(@PathVariable("id") Long id, @RequestParam(name = "date") String date) {
        return bookingService.searchBookings(
                activityService
                        .getActivityById(id)
                        .getBookings()
                        .stream().toList(),
                date
        );
    }

    //Create an activity
    @PostMapping("/activities")
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity){
        Activity newActivity = activityService.createActivity(activity);
        return new ResponseEntity<>(newActivity, HttpStatus.CREATED);
    }

    //Update an activity
    @PutMapping("/activities/{id}")
    public ResponseEntity<Activity> updateActivity(@RequestBody Activity newActivity, @PathVariable("id") Long id) {
        //if activity not find return not found status
        if (activityService.getActivityById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(id==null || id<=0 || newActivity==null || newActivity.getId()==null ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
        else{
            Activity activity = activityService.updateActivity( id, newActivity);
            return new ResponseEntity<>(activity, HttpStatus.OK);
        }

    }


    //Delete an activity
    @DeleteMapping("/activities/{id}")
    public ResponseEntity<?> deleteActivity(@PathVariable("id") Long id){
        activityService.deleteActivity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/activities/search/{keyword}")
    public List<Activity> findByKeyword(@PathVariable("keyword") String keyword){
        if(keyword != null|| keyword != "" || keyword != " "){
            return activityService.findByKeywordActivity(keyword);
        }
        return activityService.getAllActivities();
    }


}