package com.adventure.adventurexp.Controller;

import com.adventure.adventurexp.Entity.Activity;
import com.adventure.adventurexp.Entity.Instructor;
import com.adventure.adventurexp.Repository.ActivityRepository;
import com.adventure.adventurexp.Service.ActivityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ActivityController.class)
class ActivityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ActivityService activityService;

    private List<Activity> activityList;


    @BeforeEach
    void setUp() {
        activityList = new ArrayList<>();
        activityList.add(new Activity("Gokart", "In go-karting, the participants drive around a course racing the be the first one across the finish line after 20 laps. Points are given based on placement. The participant with the fastest lap will receive 5 bonus points. Age limit: 16+.", new Instructor("Ricky", "Raceman"), "gokart.jpg"));
        activityList.add(new Activity("Minigolf", "Golf, but mini. It's played on courses consisting of 24 holes. Players aim is to have the least amount of attempts at the end of the game. Players have a maximum of 7 tries per hole. Age limit: 5+.", new Instructor("Ricky", "Raceman"), "minigolf.jpg"));
        activityList.add(new Activity("Paintball", "Two teams will go against each other. The purpose is to shoot the opposing team with paint balls until only members from one team is left. Age limit: 18+.", new Instructor("Ricky", "Raceman"), "paintball.jpg"));
    }

    @Test
    void contextLoad() {
        assertThat(mockMvc).isNotNull();
    }

    @Test
    void getAllActivities() throws Exception {
        Mockito.when(activityService.getAllActivities()).thenReturn(activityList);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/activities")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("[*]").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("[*].id").isNotEmpty());
    }

    @Test
    void getActivityById() {
    }

    @Test
    void createActivity() throws Exception {
        Activity activity = new Activity("Gokart", "In go-karting, the participants drive around a course racing the be the first one across the finish line after 20 laps. Points are given based on placement. The participant with the fastest lap will receive 5 bonus points. Age limit: 16+.", new Instructor("Ricky", "Raceman"), "gokart.jpg");

        Mockito.when(activityService.createActivity(Mockito.any())).thenReturn(activity);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/activities")
                        .content(asJsonString(activity))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("*.id").exists());
    }

    @Test
    void updateActivity() {
    }

    @Test
    void deleteActivity() {
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}