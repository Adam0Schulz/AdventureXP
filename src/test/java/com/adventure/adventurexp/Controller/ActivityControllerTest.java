package com.adventure.adventurexp.Controller;

import static java.lang.reflect.Array.get;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.adventure.adventurexp.Entity.Activity;
import com.adventure.adventurexp.Entity.Instructor;
import com.adventure.adventurexp.Repository.ActivityRepository;
import com.adventure.adventurexp.Service.ActivityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@ExtendWith(MockitoExtension.class)
class ActivityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ActivityService activityService;

    @MockBean
    private ActivityRepository activityRepository;

    private Activity activity;

    private long id;

    @BeforeEach
    void setUp() {
        activityService = new ActivityService(activityRepository);
        activity = new Activity("Gokart",
                "In go-karting, the participants drive around a course racing the be the first one across the finish line after 20 laps. " +
                        "Points are given based on placement. The participant with the fastest lap will receive 5 bonus points. Age limit: 16+.",
                new Instructor("Tom", "Thomson")
        );
        id = 10L;
    }

    @Test
    void getAllActivities() {
    }

    @Test
    void getActivityById() {
    }

    @Test
    void createActivity() {

    }

    @Test
    void updateActivity() {
    }

    @Test
    void deleteActivity() {
    }
}