package com.adventure.adventurexp.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "activty")
public class Activity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column
        private String name;

        @Column(length = 6000)
        private String description;

        @OneToOne
        @JoinColumn(name = "instructor_id")
        private Instructor instructor;

        @OneToMany
        @JoinColumn(name = "activity_id")
        @JsonBackReference
        private Set<Booking> bookings = new HashSet<>();

        public Activity(String name, String description){
                this.name=name;
                this.description=description;
        }
}