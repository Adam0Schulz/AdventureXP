package com.adventure.adventurexp.Entity;

import javax.persistence.*;

@Entity
public class Activity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column
        private String name;

        @Column
        private String description;

        public Activity(){};

        public Activity(String name, String description){
            this.name=name;
            this.description=description;

        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }
}
