package com.training.hotel.repository;

import com.training.hotel.domain.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepositroy extends CrudRepository<Hotel,Integer> {

}
