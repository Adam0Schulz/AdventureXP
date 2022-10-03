package com.adventure.adventurexp.Controller;

import com.adventure.adventurexp.Entity.Customer;
import com.adventure.adventurexp.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/customers/{id}")
public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id){
    Customer customer = customerService.getCustomerById(id);
    return new ResponseEntity<>(customer, HttpStatus.OK);
}




}
