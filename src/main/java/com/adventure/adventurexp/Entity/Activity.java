package com.adventure.adventurexp.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "activity")
public class Activity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column
        private String name;

        @Column(length = 6000)
        private String description;

        public Activity(String name, String description){
            this.name=name;
            this.description=description;
        }

        @OneToMany(mappedBy = "activity")
        private List<Booking> booking;
}