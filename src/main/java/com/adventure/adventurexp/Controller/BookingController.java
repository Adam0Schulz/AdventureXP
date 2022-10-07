package com.adventure.adventurexp.Controller;

import com.adventure.adventurexp.Entity.Booking;
import com.adventure.adventurexp.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BookingController
{
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService)
    {
        this.bookingService = bookingService;
    }

    //Return all bookings
    @GetMapping("/bookings")
    public List<Booking> getAllBookings()
    {
        return bookingService.getAllBookings();
    }

    //Return bookings by id
    @GetMapping("/bookings/{id}")
    public ResponseEntity<Booking> getBookingsById(@PathVariable("id") Long id)
    {
        Booking booking = bookingService.getBookingsById(id);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    //Create booking
    @PostMapping("/bookings")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking)
    {


            Booking newBooking = bookingService.createBooking(booking);
            return new ResponseEntity<>(newBooking, HttpStatus.CREATED);

        }





    //Update Booking
    @PutMapping("/bookings/{id}")
    public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking, @PathVariable("id") Long id)
    {
        return new ResponseEntity<Booking>(bookingService.updateBooking(id, booking), HttpStatus.OK);
}


    //Delete Booking
    @DeleteMapping("/bookings/{id}")
    public ResponseEntity<?> deleteBooking (@PathVariable ("id") Long id)
    {
        bookingService.deleteBooking(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
