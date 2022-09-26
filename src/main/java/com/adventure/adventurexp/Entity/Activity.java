package com.adventure.adventurexp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Activity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;


}
