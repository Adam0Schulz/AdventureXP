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
        Activity goKart = new Activity("Gokart","In go-karting, the participants drive around a course racing the be the first one across the finish line after 20 laps. Points are given based on placement. The participant with the fastest lap will receive 5 bonus points. Age limit: 16+.", "gokart.jpg");
        Activity sumoWrestling = new Activity("Sumo Wrestling", "The participants will wear an inflatable sumo suit and wrestle each other. The purpose is to push the opponent outside of the wrestling ring. Age limit: 11+.", "sumo_wrestling.jpg");
        Activity miniGolf = new Activity("Minigolf", "Golf, but mini. It's played on courses consisting of 24 holes. Players aim is to have the least amount of attempts at the end of the game. Players have a maximum of 7 tries per hole. Age limit: 5+.", "minigolf.jpg");
        Activity paintBall = new Activity("Paintball","Two teams will go against each other. The purpose is to shoot the opposing team with paint balls until only members from one team is left. Age limit: 18+.", "paintball.jpg");
        Activity beachVolleyball = new Activity("Beach Volleyball", "The participants play in teams of two on a sanded volleyball court with a net dividing them. The objective is to send the ball over the net and to hit the opposite teams sand floor. Each team has a max of three touches before the ball must be send over the net. A set is won by the first team to reach 21 points (15 points in the deciding final set) with a two-point advantage. A match is won by whoever wins two sets. Age limit 8+", "beach_volleyball.jpg");
        Activity drivingRangeGolf = new Activity("Driving Range Golf", "The participants will rent a tee and a bucket off balls.  This activity can be used for golfers that want to practice their golf swings, or it can be used as a game where participants can shoot for specific targets on the golf course and compete to see who gets the most points. Age limit: 8+", "driving_range_golf.jpg");

        activityRepository.save(goKart);
        activityRepository.save(sumoWrestling);
        activityRepository.save(miniGolf);
        activityRepository.save(paintBall);
        activityRepository.save(beachVolleyball);
        activityRepository.save(drivingRangeGolf);
    }
}