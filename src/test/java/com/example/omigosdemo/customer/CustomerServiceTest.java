package com.example.omigosdemo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;

    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerService = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        Customer customer1 = new Customer(1L, "name1", "password1", "email1@email.com");
        Customer customer2 = new Customer(2L, "name2", "password2", "email2@email.com");

        customerRepository.saveAll(Arrays.asList(customer1, customer2));

        List<Customer> customers = customerService.getCustomers();

        assertEquals(2, customers.size());
    }

    @Test
    void getCustomer() {
        Customer customer2 = new Customer(2L, "name2", "password2", "email2@email.com");

        customerRepository.save(customer2);

        Customer customer = customerService.getCustomer(2L);

        assertEquals(2L, customer.getId());
        assertEquals("name2", customer.getName());
        assertEquals("password2", customer.getPassword());
        assertEquals("email2@email.com", customer.getEmail());
    }
}