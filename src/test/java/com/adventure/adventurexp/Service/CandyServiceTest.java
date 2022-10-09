package com.adventure.adventurexp.Service;

import com.adventure.adventurexp.Entity.Booking;
import com.adventure.adventurexp.Entity.Candy;
import com.adventure.adventurexp.Repository.CandyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CandyServiceTest {

    @Mock
    private CandyRepository candyRepository;

    private CandyService candyService;

    private long id;

    private Candy candy;

    @BeforeEach
    void setUp() {
        candyService = new CandyService(candyRepository);
        id = 10L;
        candy = new Candy("Salty Monkey",20.5);
    }

    @Test
    void canGetAllCandy() {
        candyService.getAllCandy();

        verify(candyRepository).findAll();
    }

    @Test
    void canGetCandyById() {
        candyService.getCandyById(id);

        verify(candyRepository).findById(id);
    }

    @Test
    void createCandy() {
        //when
        candyService.createCandy(candy);

        //then
        ArgumentCaptor<Candy> bookingArgumentCaptor = ArgumentCaptor.forClass(Candy.class);
        verify(candyRepository).save(bookingArgumentCaptor.capture());
        Candy capturedCandy = bookingArgumentCaptor.getValue();
        assertThat(capturedCandy).isEqualTo(candy);
    }

    @Test
    void updateCandy() {
        //given - precondition or setup
        candy.setPrice(25.5);

        Mockito.when(candyRepository.findById(id)).thenReturn(Optional.ofNullable(candy));
        Mockito.when(candyRepository.save(candy)).thenReturn(candy);

        //when -  action or the behaviour that we are going test
        Candy updatedCandy = candyService.updateCandy(id, candy);

        //then - verify the output
        assertThat(updatedCandy.getPrice()).isEqualTo(25.5);
      }

    @Test
    void canUpdateActivityReturnNull() {
        //when -  action or the behaviour that we are going test
        Candy updatedCandy = candyService.updateCandy(id, candy);

        //then - verify the output
        assertThat(updatedCandy).isNull();
    }
}