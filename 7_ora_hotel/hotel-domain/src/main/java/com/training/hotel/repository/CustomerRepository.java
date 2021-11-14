package com.training.hotel.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.hotel.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{

	Customer findByEmail(String email);

}
