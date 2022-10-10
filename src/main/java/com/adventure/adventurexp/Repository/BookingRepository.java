package com.adventure.adventurexp.Repository;

import com.adventure.adventurexp.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long>
{
//get booking by id
    @Query("SELECT b FROM Booking AS b WHERE b.id=?1")
    Booking getBookingById(Long id);


    //find all bookings by activity id
    @Query("SELECT b FROM Booking AS b WHERE b.activity.id=?1")
    List<Booking> findAllByActivityId(Long activityId);


}




