package com.training.hotel.application.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.hotel.domain.Customer;
import com.training.hotel.domain.Hotel;
import com.training.hotel.domain.Reservation;
import com.training.hotel.domain.Room;
import com.training.hotel.repository.CustomerRepository;
import com.training.hotel.repository.HotelRepository;
import com.training.hotel.repository.ReservationRepository;
import com.training.hotel.repository.RoomRepository;

@Service
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	public Iterable<Hotel> findAllHotel() {
		return hotelRepository.findAll();
	}


	public Iterable<Room> findAllRoomsByHotelId(int hotelId) {
		return roomRepository.findByHotelId(hotelId);
	}
	
	public Reservation saveReservation(int roomId) {
		Room room = roomRepository.findById(roomId).get();
		Customer customer = customerRepository.findByEmail("customer@test.com");
		
		Reservation reservation = new Reservation();
		reservation.setRoom(room);
		reservation.setCustomer(customer);
		reservation.setArrival(LocalDate.now());
		reservation.setDeparture(LocalDate.now());
		
		return reservationRepository.save(reservation);
		
		
	}


	public Hotel saveHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
		
	}
	
	
}
