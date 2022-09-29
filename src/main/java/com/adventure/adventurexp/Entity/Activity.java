package com.adventure.adventurexp.Entity;

import jdk.jshell.Snippet;
import lombok.*;

import javax.persistence.*;

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

        public Activity(String name, String description){
            this.name=name;
            this.description=description;
        }
}