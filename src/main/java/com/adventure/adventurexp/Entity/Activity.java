package com.adventure.adventurexp.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "activity")
public class Activity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column
        private String name;

        @Column(length = 6000)
        private String description;

        @Column
        private String imageName;

        @OneToOne
        @JoinColumn(name = "instructor_id")
        private Instructor instructor;

        @OneToMany
        @JoinColumn(name = "activity_id")
        @JsonBackReference
        private Set<Booking> bookings = new HashSet<>();

        public Activity(String name, String description, Instructor instructor, String imageName){
                this.name=name;
                this.description=description;
                this.instructor = instructor;
                this.imageName=imageName;
        }
}