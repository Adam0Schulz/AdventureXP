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
        Activity goKart = new Activity("Gokart","In go-karting, the participants drive around a course racing the be the first one across the finish line after 20 laps. Points are given based on placement. The participant with the fastest lap will receive 5 bonus points. Age limit: 16+.");
        Activity sumoWrestling = new Activity("Sumo Wrestling", "The participants will wear an inflatable sumo suit and wrestle each other. The purpose is to push the opponent outside of the wrestling ring. Age limit: 11+. ");
        Activity miniGolf = new Activity("Minigolf", "Golf, but mini. It's played on courses consisting of 24 holes. Players aim is to have the least amount of attempts at the end of the game. Players have a maximum of 7 tries per hole. Age limit: 5+. ");
        Activity paintBall = new Activity("Paintball","Two teams will go against each other. THe purpose is to shoot the opposing team with paint balls until only members from one team is left. Age limit: 18+.");
        activityRepository.save(goKart);
        activityRepository.save(sumoWrestling);
        activityRepository.save(miniGolf);
        activityRepository.save(paintBall);

    }
}