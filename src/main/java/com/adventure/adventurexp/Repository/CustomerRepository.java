package com.adventure.adventurexp.Repository;

import com.adventure.adventurexp.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

