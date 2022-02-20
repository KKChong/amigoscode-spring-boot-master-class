package com.example.omigosdemo.customer;

import com.example.omigosdemo.expection.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {
    private final CustomerRepository customerRepository;

    List<Customer> getCustomers() {
        log.info("getCustomers was called");
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> {
                    NotFoundException notFoundException = new NotFoundException("ID " + id + " not found");
                    log.error("getCustomer with {}", id, notFoundException);
                    return notFoundException;
                });
    }
}
