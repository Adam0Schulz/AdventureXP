package com.adventure.adventurexp.Service;

import com.adventure.adventurexp.Entity.Booking;
import com.adventure.adventurexp.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService
{
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository)
    {
        this.bookingRepository = bookingRepository;
    }

    // Find all bookings
    public List<Booking> getAllBookings()
    {
        return bookingRepository.findAll();
    }

    // Find booking by id
    public Booking getBookingsById(Long id)
    {
        return bookingRepository.findById(id).get();
    }

    //Add a booking
    public Booking createBooking(Booking booking)

    {

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

    //RETURN ALL BOOKINGS BY ACTIVITY ID
@Transactional
    public boolean checkActivityIsAvailable(Long activityId, LocalDate date, LocalTime startTime, LocalTime endTime)
    {
        List<Booking> bookings = bookingRepository.findAllByActivityId(activityId);
        List<Booking> availableBookings = new ArrayList<>();
        for (Booking booking : bookings)
        {
            if (booking.getDate().equals(date))
            {
                if (booking.getStartTime().equals(startTime) || booking.getEndTime().equals(endTime))
                {
                    availableBookings.add(booking);
                    throw new IllegalStateException("Activity is not available");

                }
                else if (booking.getStartTime().isBefore(startTime) && booking.getEndTime().isAfter(startTime))
                {
                    availableBookings.add(booking);
                    throw new IllegalStateException("Activity is not available");
                }
                else if (booking.getStartTime().isBefore(endTime) && booking.getEndTime().isAfter(endTime))
                {
                    availableBookings.add(booking);
                    throw new IllegalStateException("Activity is not available");
                }



            }

        }
        return true;
    }



}
