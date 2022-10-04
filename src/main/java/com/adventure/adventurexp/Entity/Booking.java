package com.adventure.adventurexp.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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

    @Column
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @Column
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    @Column
    private int numberOfParticipants;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
