package com.adventure.adventurexp.Service;

import com.adventure.adventurexp.Entity.Activity;
import com.adventure.adventurexp.Entity.Customer;
import com.adventure.adventurexp.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepo;
    @Autowired
    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }


    public List<Customer> getAllCustomers() {
        List<Customer> customersList = customerRepo.findAll();
        return customersList;
    }
    //get customer by id
    public Customer getCustomerById(Long id) {
        return customerRepo.findById(id).get();
    }
}
