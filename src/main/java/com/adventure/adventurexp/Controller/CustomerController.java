package com.adventure.adventurexp.Controller;

import com.adventure.adventurexp.Entity.Booking;
import com.adventure.adventurexp.Entity.Activity;
import com.adventure.adventurexp.Entity.Customer;
import com.adventure.adventurexp.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    //return all customers
    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    //return customer by id
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id){
    Customer customer = customerService.getCustomerById(id);
    return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    //Create customer
    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer)
    {
        Customer newCustomer = customerService.createCustomer(customer);
        return newCustomer;
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer newCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer newCustomer, @PathVariable("id")Long id){
        return new ResponseEntity<Customer>(customerService.updateCustomer(id, newCustomer),
                HttpStatus.OK);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //find by keyword and put it in list of customers
    @GetMapping("/customers/search/{keyword}")
    public List<Customer> findByKeyword(@PathVariable("keyword") String keyword){
        return customerService.findByKeyword(keyword);
    }



}


