package com.adventure.adventurexp.Service;

import com.adventure.adventurexp.Entity.Customer;
import com.adventure.adventurexp.Repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    private CustomerService customerService;

    private long id;

    private Customer customer;

    @BeforeEach
    void setUp() {
        customerService = new CustomerService(customerRepository);
        id = 10L;
        customer = new Customer("Rita", "Maria", "ritamail@mailer.com", "+45/23 31 23 32");
    }

    @Test
    void canGetAllCustomers() {
        customerService.getAllCustomers();

        verify(customerRepository).findAll();
    }

    @Test
    void canGetCustomerById() {
        customerService.getCustomerById(id);

        verify(customerRepository).findById(id);
    }
}