package com.adventure.adventurexp;

import com.adventure.adventurexp.Entity.Activity;
import com.adventure.adventurexp.Repository.ActivityRepository;
import com.adventure.adventurexp.Service.ActivityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.security.Provider;
import java.util.Optional;

@DataJpaTest
class AdventureXpApplicationTests {



    ActivityRepository activityRepository;

    @Autowired
    public AdventureXpApplicationTests(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }




    @Test
    void addActivity() {
        Activity goKart = new Activity("Gokart","In go-karting, the participants drive around a course racing the be the first one across the finish line after 20 laps. Points are given based on placement. The participant with the fastest lap will receive 5 bonus points. Age limit: 16+.");
        Activity sumoWrestling = new Activity("Sumo Wrestling", "The participants will wear an inflatable sumo suit and wrestle each other. The purpose is to push the opponent outside of the wrestling ring. Age limit: 11+. ");
        activityRepository.save(goKart);
        activityRepository.save(sumoWrestling);

    }

    @Test
    void deleteActivity(){
        Activity sumoWrestling = new Activity("Sumo Wrestling", "The participants will wear an inflatable sumo suit and wrestle each other. The purpose is to push the opponent outside of the wrestling ring. Age limit: 11+. ");
        activityRepository.save(sumoWrestling);
        activityRepository.delete(sumoWrestling);
    }

        @Test
        void deleteByIdActivity(){
        Activity sumoWrestling = new Activity("Sumo Wrestling", "The participants will wear an inflatable sumo suit and wrestle each other. The purpose is to push the opponent outside of the wrestling ring. Age limit: 11+. ");
        activityRepository.save(sumoWrestling);
        activityRepository.deleteById(1l);
    }

    @Test
   void findByIdActivity(){
        Activity sumoWrestling = new Activity("Sumo Wrestling", "The participants will wear an inflatable sumo suit and wrestle each other. The purpose is to push the opponent outside of the wrestling ring. Age limit: 11+. ");
        activityRepository.save(sumoWrestling);
         activityRepository.findById(1l);
    }







}
