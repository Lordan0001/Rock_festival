package com.example.bialitski.rock_festival.interfaces;

import com.example.bialitski.rock_festival.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
