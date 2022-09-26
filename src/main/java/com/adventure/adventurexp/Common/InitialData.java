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
        activityRepository.save(goKart);
    }
}