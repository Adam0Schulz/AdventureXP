package com.adventure.adventurexp.Repository;

import com.adventure.adventurexp.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long>
{

}
