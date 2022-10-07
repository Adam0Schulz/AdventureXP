package com.adventure.adventurexp;

import com.adventure.adventurexp.Entity.Activity;
import com.adventure.adventurexp.Repository.ActivityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@DataJpaTest
class AdventureXpApplicationTests {


    ActivityRepository activityRepository;

    @Autowired
    public AdventureXpApplicationTests(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }





}
