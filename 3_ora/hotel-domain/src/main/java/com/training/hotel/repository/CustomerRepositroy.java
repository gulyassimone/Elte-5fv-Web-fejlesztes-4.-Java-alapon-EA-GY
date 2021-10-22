package com.training.hotel.repository;

import com.training.hotel.domain.Customer;
import com.training.hotel.domain.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepositroy extends CrudRepository<Customer,Integer> {

    Customer findByEmail(String s);
}
