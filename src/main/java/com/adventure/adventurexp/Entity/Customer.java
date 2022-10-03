package com.adventure.adventurexp.Entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter

@NoArgsConstructor
@Entity

@Table(name = "customer")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (length = 600)
    private String firstname;
    @Column (length = 600)
    private String lastname;
    @Column (length = 600)
    private String email;
    @Column (length = 600)
    private String phone;

    public Customer(Long id, String firstname, String lastname, String email, String phone) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
    }
}
