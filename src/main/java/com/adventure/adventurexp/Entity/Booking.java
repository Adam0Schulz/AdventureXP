package com.adventure.adventurexp.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    @Column
    //LocalDateFormat: LocalDate.of(2022, 10, 10)
    private LocalDate date;

    @Column
    //LocalTimeFormat: LocalTime.of(5,30)
    private LocalTime startTime;

    @Column
    //LocalTimeFormat: LocalTime.of(7,30)
    private LocalTime endTime;

    @Column
    private int numberOfParticipants;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Booking(Activity activity, LocalDate date, LocalTime startTime, LocalTime endTime, int numberOfParticipants, Customer customer) {
        this.activity = activity;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.numberOfParticipants = numberOfParticipants;
        this.customer = customer;
    }
}