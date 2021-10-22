package com.training.hotel.application.service;

import com.training.hotel.domain.Customer;
import com.training.hotel.domain.Hotel;
import com.training.hotel.domain.Reservation;
import com.training.hotel.domain.Room;
import com.training.hotel.repository.CustomerRepositroy;
import com.training.hotel.repository.HotelRepositroy;
import com.training.hotel.repository.ReservationRepositroy;
import com.training.hotel.repository.RoomRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.time.LocalDate;

@Service // ő egy réteg, vagyis egy komponens
public class HotelService {

    @Autowired
    private HotelRepositroy hotelRepositroy;

    @Autowired
    private RoomRepositroy roomRepositroy;

    @Autowired
    private CustomerRepositroy customerRepositroy;

    @Autowired
    private ReservationRepositroy reservationRepositroy;

    @Transactional
    public Iterable<Hotel> findAllHotel() {
        Iterable<Hotel> hotels = hotelRepositroy.findAll();
        hotels.forEach(hotel -> hotel.getRooms().size());

        return hotels;
    }

    public Iterable<Room> findAllRoomsByHotelId(int hotelId){
        return roomRepositroy.findByHotelId(hotelId);
    }

    public Reservation saveReservation(int roomId){
        Room room=roomRepositroy.findById(roomId).get();
        Customer customer = customerRepositroy.findByEmail("customer@test.com");

        Reservation reservation = new Reservation();
        reservation.setRoom(room);
        reservation.setCustomer(customer);
        reservation.setArrival(LocalDate.now());
        reservation.setDeparture(LocalDate.now());

        return reservationRepositroy.save(reservation);
    }
}
