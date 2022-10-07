package com.adventure.adventurexp.Service;

import com.adventure.adventurexp.Entity.Booking;
import com.adventure.adventurexp.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return bookingRepository.findById(id).orElse(null);
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
}
