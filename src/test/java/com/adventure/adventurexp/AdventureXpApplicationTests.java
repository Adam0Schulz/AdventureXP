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

    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


    @Test
    void createInstructor() {
        Instructor instructor = new Instructor("Ricky", "Raceman");
        instructorRepository.save(instructor);
    }
    @Test
    void createActivity(){
        Instructor instructor = new Instructor("Ricky", "Raceman");
        Activity goKart = new Activity("Gokart","In go-karting, the participants drive around a course racing the be the first one across the finish line after 20 laps. Points are given based on placement. The participant with the fastest lap will receive 5 bonus points. Age limit: 16+.", instructor);
        activityRepository.save(goKart);
    }

    @Test
    void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Test
    void createBooking() {
        Customer customer = new Customer("John", "Doe", "ghgh@jhdhj.dk","12345678");
        Instructor instructor = new Instructor("Ricky", "Raceman");
        Activity goKart = new Activity("Gokart","In go-karting, the participants drive around a course racing the be the first one across the finish line after 20 laps. Points are given based on placement. The participant with the fastest lap will receive 5 bonus points. Age limit: 16+.", instructor);
        Booking booking = new Booking(goKart, LocalDate.of(2022, 10, 10), LocalTime.of(5,30), LocalTime.of(7,30), 4, customer);
        bookingRepository.save(booking);
    }

    void editBooking(Booking booking) {
    }
}