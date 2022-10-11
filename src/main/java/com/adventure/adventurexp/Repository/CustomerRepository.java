package com.adventure.adventurexp.Repository;

import com.adventure.adventurexp.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Long countById(Long id);

    @Query("SELECT c FROM Customer c WHERE c.firstname LIKE %?1% OR c.lastname LIKE %?1% OR c.email LIKE %?1% OR c.phone LIKE %?1%")
    List<Customer> findByKeyword(String keyword);

}

