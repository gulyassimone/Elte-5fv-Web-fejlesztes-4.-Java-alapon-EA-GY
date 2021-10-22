package com.training.hotel.repository;

import com.training.hotel.domain.Hotel;
import com.training.hotel.domain.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepositroy extends CrudRepository<Room,Integer> {
    Iterable<Room> findByHotelId(int id);
}
