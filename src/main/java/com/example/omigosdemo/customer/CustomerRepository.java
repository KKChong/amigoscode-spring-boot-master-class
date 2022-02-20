package com.example.omigosdemo.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
