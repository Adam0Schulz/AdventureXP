package com.adventure.adventurexp;

import com.adventure.adventurexp.Entity.Activity;
import com.adventure.adventurexp.Entity.Booking;
import com.adventure.adventurexp.Entity.Customer;
import com.adventure.adventurexp.Entity.Instructor;
import com.adventure.adventurexp.Repository.ActivityRepository;
import com.adventure.adventurexp.Repository.BookingRepository;
import com.adventure.adventurexp.Repository.CustomerRepository;
import com.adventure.adventurexp.Repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import static org.mockito.Mockito.when;

@DataJpaTest
@RequiredArgsConstructor
class AdventureXpApplicationTests {

    private final ActivityRepository activityRepository;

    private final CustomerRepository customerRepository;

    private final InstructorRepository instructorRepository;

    private final BookingRepository bookingRepository;

}