package com.example.omigosdemo.customer;

import com.example.omigosdemo.expection.ApiRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "api/v1/customers")
@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    List<Customer> customers() {
        return customerService.getCustomers();
    }

    @GetMapping({"{id}"})
    Customer customer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @GetMapping({"{id}/exception"})
    Customer customerException(@PathVariable Long id) {
        throw new ApiRequestException("Customer with " + id + " not found");
    }

    @PostMapping
    void createNewCustomer(@Valid @RequestBody Customer customer) {
        System.out.println("create new customer: " + customer);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer) {
        System.out.println("update customer: " + customer);
    }

    @DeleteMapping("{id}")
    void deleteCustomer(@PathVariable("id") Long id) {
        System.out.println("delete customer: " + id);
    }

}
