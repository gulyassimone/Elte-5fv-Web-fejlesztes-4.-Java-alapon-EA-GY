package com.training.hotel.repository;

import com.training.hotel.domain.Customer;
import com.training.hotel.domain.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepositroy extends CrudRepository<Reservation,Integer> {


}
