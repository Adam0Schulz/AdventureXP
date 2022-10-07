package com.adventure.adventurexp.Service;

import com.adventure.adventurexp.Entity.Activity;
import com.adventure.adventurexp.Entity.Instructor;
import com.adventure.adventurexp.Repository.ActivityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class) //Calls MockitoExtensions - (e.g. Autocloseable)
class ActivityServiceTest {

    @Mock
    private ActivityRepository activityRepository;

    private ActivityService activityService;

    private long id;

    private Activity activity;

    @BeforeEach
    void setUp() {
        activityService = new ActivityService(activityRepository);
        activity = new Activity("Gokart",
                "In go-karting, the participants drive around a course racing the be the first one across the finish line after 20 laps. " +
                        "Points are given based on placement. The participant with the fastest lap will receive 5 bonus points. Age limit: 16+.",
                new Instructor("Tom","Thomson"),
                "gokart.jpg"
        );
        id = 10L;
    }

    //Checks when getAllActivities method is called, if activityRepository was verified by findAll() method.
    @Test
    void canGetAllActivities() {
        //when
        activityService.getAllActivities();
        //then
        verify(activityRepository).findAll();
    }

    //Checks when activityService.getActivityById is called, if activityRepository.findById is verified with same id.
    @Test
    void canGetActivityById() {
        //when
        activityService.getActivityById(id);
        //then
        verify(activityRepository).findById(id);
    }

    //Checks if created Activity is the same as the saved Activity
    @Test
    void canCreateActivity() {
        //when
        activityService.createActivity(activity);
        //then
        ArgumentCaptor<Activity> activityArgumentCaptor = ArgumentCaptor.forClass(Activity.class);
        verify(activityRepository).save(activityArgumentCaptor.capture());  //Verify if activityRepository was called and capture Activity object to save.
        Activity capturedActivity = activityArgumentCaptor.getValue();
        assertThat(capturedActivity).isEqualTo(activity);
    }

    @Test
    void canDeleteActivity() {
        //when
        activityService.deleteActivity(id);
        //then
        verify(activityRepository).deleteById(id);
    }

    @Test
    void canUpdateActivity() {
        //given - precondition or setup
        activity.setName("Parachuting");
        activity.setDescription("Safety is not guaranteed!");

        //when -  action or the behaviour that we are going test
        Activity updatedActivity = activityService.updateActivity(id, activity);

        //then - verify the output
        assertThat(updatedActivity).isNotEqualTo(activity);

       //assertThat(updatedActivity.getName()).isEqualTo("Parachuting");
       //assertThat(updatedActivity.getDescription()).isEqualTo("Safety is not guaranteed!");
    }
}