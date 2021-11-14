package com.training.hotel.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.hotel.domain.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Integer>{

}
