package com.adventure.adventurexp.Service;

import com.adventure.adventurexp.Entity.Activity;
import com.adventure.adventurexp.Entity.Booking;
import com.adventure.adventurexp.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class BookingService
{
    private final BookingRepository bookingRepository;
    private final ActivityService activityService;

    @Autowired
    public BookingService(BookingRepository bookingRepository, ActivityService activityService)
    {
        this.bookingRepository = bookingRepository;
        this.activityService = activityService;
    }

    // Find all bookings
    public List<Booking> getAllBookings()
    {
        return bookingRepository.findAll();
    }

    // Find booking by id
    public Booking getBookingsById(Long id)
    {
        return bookingRepository.findById(id).orElse(null);
    }

    //Add a booking
    public Booking createBooking(Booking booking, Long activityId)
    {
        Activity activity = activityService.getActivityById(activityId);
        booking.setActivity(activity);
        if(booking.getStartTime().isBefore(LocalTime.of(7,0))
                || booking.getEndTime().isAfter(LocalTime.of(15,0))) return null;
        return bookingRepository.save(booking);
    }

    //Delete booking
    public void deleteBooking(Long id)
    {
        bookingRepository.deleteById(id);
    }

    //Update booking
    public Booking updateBooking(Long id, Booking booking)
    {
        if (bookingRepository.findById(id).isEmpty())
        {
            return null;
        }
        return bookingRepository.save(booking);
    }
}
