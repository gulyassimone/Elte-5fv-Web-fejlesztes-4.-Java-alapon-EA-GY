package com.training.hotel.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.hotel.domain.Room;

public interface RoomRepository extends CrudRepository<Room, Integer>{

	Iterable<Room> findByHotelId(int id);
}
