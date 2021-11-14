package com.training.hotel.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.hotel.domain.Hotel;

public interface HotelRepository extends CrudRepository<Hotel, Integer>{

}
