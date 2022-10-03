package com.adventure.adventurexp.Entity;

import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;

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

    public Customer( String firstname, String lastname, String email, String phone) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
    }
}
