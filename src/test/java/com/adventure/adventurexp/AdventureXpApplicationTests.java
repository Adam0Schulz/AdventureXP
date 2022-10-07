package com.adventure.adventurexp;

import com.adventure.adventurexp.Entity.Activity;
import com.adventure.adventurexp.Entity.Instructor;
import com.adventure.adventurexp.Repository.ActivityRepository;
import com.adventure.adventurexp.Repository.BookingRepository;
import com.adventure.adventurexp.Repository.CustomerRepository;
import com.adventure.adventurexp.Repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@RequiredArgsConstructor
class AdventureXpApplicationTests {

    private final ActivityRepository activityRepository;

    private final CustomerRepository customerRepository;

    private final InstructorRepository instructorRepository;

    private final BookingRepository bookingRepository;

    @Test
    void createActivities(){
        Instructor instructor = new Instructor("Ricky", "Raceman");
        Activity paintBall = new Activity("Paintball","Two teams will go against each other. The purpose is to shoot the opposing team with paint balls until only members from one team is left. Age limit: 18+.", instructor, "paintball.jpg");
        activityRepository.save(paintBall);
    }


}
