package com.adventure.adventurexp.Common;


import com.adventure.adventurexp.Entity.Activity;
import com.adventure.adventurexp.Repository.ActivityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitialData implements CommandLineRunner {

    ActivityRepository activityRepository;

    public InitialData(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Activity goKart = new Activity("Gokart","It's a funny activity");
        Activity sumoWrestling = new Activity("Sumo Wrestling", "The participants will wear an inflatable sumo suit, and wrestle each other. The purpose is to push the opponent outside of the wrestling ring. ");
        Activity miniGolf = new Activity("Minigolf", "Golf, but mini");
        Activity paintBall = new Activity("Paintball","Two teams will go against each other. THe purpose is to shot the opposing team with paintballs until only members from one team is left");
        activityRepository.save(goKart);
        activityRepository.save(sumoWrestling);
        activityRepository.save(miniGolf);
        activityRepository.save(paintBall);

    }
}