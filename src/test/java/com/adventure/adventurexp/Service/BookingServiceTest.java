package com.adventure.adventurexp.Service;

import com.adventure.adventurexp.Entity.Activity;
import com.adventure.adventurexp.Entity.Booking;
import com.adventure.adventurexp.Entity.Customer;
import com.adventure.adventurexp.Entity.Instructor;
import com.adventure.adventurexp.Repository.BookingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {
    @Mock
    private BookingRepository bookingRepository;

    private BookingService bookingService;
    private ActivityService activityService;

    private long id;

    private Booking booking;
    private Long activityId;

    @BeforeEach
    void setUp() {
        bookingService = new BookingService(bookingRepository, activityService);
        id = 10L;
        Instructor instructor = new Instructor("Ricky", "Raceman");
        Customer customer = new Customer("John", "Doe", "ghgh@jhdhj.dk", "12345678");
        Activity activity = new Activity("Gokart", "In go-karting, the participants drive around a course racing the be the first one across the finish line after 20 laps. Points are given based on placement. The participant with the fastest lap will receive 5 bonus points. Age limit: 16+.", instructor, "gokart.jpg");
        booking = new Booking(activity, LocalDate.of(2022, 10, 10), LocalTime.of(15, 30), LocalTime.of(17, 30), 4, customer);
    }

    @Test
    void canGetAllBookings() {
        //when
        bookingService.getAllBookings();
        //then
        verify(bookingRepository).findAll();
    }

    @Test
    void canGetBookingsById() {
        //when
        bookingService.getBookingsById(id);
        //then
        verify(bookingRepository).findById(id);
    }

    @Test
    void canCreateBooking() {
        //when
        bookingService.createBooking(booking, activityId);
        //then
        ArgumentCaptor<Booking> bookingArgumentCaptor = ArgumentCaptor.forClass(Booking.class);
        verify(bookingRepository).save(bookingArgumentCaptor.capture());
        Booking capturedBooking = bookingArgumentCaptor.getValue();
        assertThat(capturedBooking).isEqualTo(booking);
    }

    @Test
    void canDeleteBooking() {
        //when
        bookingService.deleteBooking(id);
        //then
        verify(bookingRepository).deleteById(id);
    }

    @Test
    void canUpdateBooking() {
        //given - precondition or setup
        booking.getCustomer().setFirstname("Erika");
        booking.setDate(LocalDate.of(2026, 12, 12));

        Mockito.when(bookingRepository.findById(id)).thenReturn(Optional.ofNullable(booking));
        Mockito.when(bookingRepository.save(booking)).thenReturn(booking);

        //when -  action or the behaviour that we are going test
        Booking updatedBooking = bookingService.updateBooking(id, booking);

        //then - verify the output
        assertThat(updatedBooking.getCustomer().getFirstname()).isEqualTo("Erika");
        assertThat(updatedBooking.getDate()).isEqualTo(LocalDate.of(2026, 12, 12));
    }

    @Test
    void canUpdateActivityReturnNull() {
        //when -  action or the behaviour that we are going test
        Booking updatedBooking = bookingService.updateBooking(id, booking);

        //then - verify the output
        assertThat(updatedBooking).isNull();
    }
}