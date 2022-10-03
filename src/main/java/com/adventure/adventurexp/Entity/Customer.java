package com.adventure.adventurexp.Entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter

@NoArgsConstructor
@Entity
@AllArgsConstructor

@Table(name = "customer")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private String email;
    @Column
    private String phone;

}
