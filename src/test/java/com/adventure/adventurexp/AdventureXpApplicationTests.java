package com.adventure.adventurexp;

import com.adventure.adventurexp.Entity.Activity;
import com.adventure.adventurexp.Entity.Instructor;
import com.adventure.adventurexp.Repository.ActivityRepository;
import com.adventure.adventurexp.Repository.InstructorRepository;
import com.adventure.adventurexp.Repository.InstructorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@DataJpaTest
class AdventureXpApplicationTests {

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    public AdventureXpApplicationTests(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }


    @Test
    void createInstructor() {
        Instructor instructor1 = new Instructor("Ricky", "Raceman");
        instructorRepository.save(instructor1);
    }
    @Test
    void createActivities(){
        Instructor instructor1 = new Instructor("Ricky", "Raceman");
        Activity goKart = new Activity("Gokart","In go-karting, the participants drive around a course racing the be the first one across the finish line after 20 laps. Points are given based on placement. The participant with the fastest lap will receive 5 bonus points. Age limit: 16+.", "gokar.jpg", instructor1);
        activityRepository.save(goKart);
    }


}
