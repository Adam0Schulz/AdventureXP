package com.adventure.adventurexp.Entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "booking")
public class Booking
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalDateTime startTime;
    @Column
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalDateTime endTime;
    @Column
    private int numberOfParticipants;

    @ManyToOne
    @JoinColumn (name = "activity_id")
    private Activity activity;

    @ManyToOne
    @JoinColumn(name="customer_id",nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="instructor_id",nullable = false)
    private Instructor instructor;
}
