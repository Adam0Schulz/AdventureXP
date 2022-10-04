package com.adventure.adventurexp.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

        @Column
        private String imageName;

        public Activity(String name, String description, String imageName){
            this.name=name;
            this.description=description;
            this.imageName=imageName;
        }
}