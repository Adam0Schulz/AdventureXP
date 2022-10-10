package com.adventure.adventurexp.Controller;

import com.adventure.adventurexp.Entity.Activity;
import com.adventure.adventurexp.Entity.Booking;
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

    //Return a single activity
    @GetMapping("/activities/{id}")
    public ResponseEntity<Activity> getActivityById(@PathVariable("id") Long id){
        Activity activity = activityService.getActivityById(id);
        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

    //Return all bookings connected to the activity that match provided date
    @GetMapping("/activities/{id}/bookings")
    public List<Booking> getBookingsByActivity(@PathVariable("id") Long id, @RequestParam(name = "date") String date) {
        List<Booking> bookingList = activityService.getActivityById(id).getBookings().stream().toList();
        List<Booking> searchedBookings = new ArrayList<>();

        String[] result = date.split("-");
        int year = Integer.parseInt(result[0]);
        int month = Integer.parseInt(result[1]);
        int day = Integer.parseInt(result[2]);

        LocalDate localDate = LocalDate.of(year, month, day);

        for (Booking booking : bookingList
        ) {
            if (booking.getDate().isEqual(localDate)) {
                searchedBookings.add(booking);
            }
        }
        return searchedBookings;
        //return activityService.getActivityById(id).getBookings().stream().toList();
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
        return new ResponseEntity<>(activityService.updateActivity(id, newActivity), HttpStatus.OK);
    }

    //Delete an activity
    @DeleteMapping("/activities/{id}")
    public ResponseEntity<?> deleteActivity(@PathVariable("id") Long id){
        activityService.deleteActivity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}