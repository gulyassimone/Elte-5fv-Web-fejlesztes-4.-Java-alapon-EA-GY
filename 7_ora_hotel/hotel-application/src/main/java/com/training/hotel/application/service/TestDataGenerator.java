package com.training.hotel.application.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.hotel.domain.Customer;
import com.training.hotel.domain.Hotel;
import com.training.hotel.domain.PrivateCustomer;
import com.training.hotel.domain.Room;
import com.training.hotel.domain.RoomType;
import com.training.hotel.repository.CustomerRepository;
import com.training.hotel.repository.HotelRepository;
import com.training.hotel.repository.RoomRepository;

@Component
public class TestDataGenerator {

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private CustomerRepository customerRepository;

	
	@Transactional
	public void createTestData() {
		Hotel mariott = createHotel("Mariott ***** Superior", 500);
		hotelRepository.save(mariott);
		
		Hotel interContinental = createHotel("Intercontinental ***** Superior", 1500);
		hotelRepository.save(interContinental);
		
		roomRepository.save(createRoom(interContinental, 101, 1, RoomType.SINGLE));
		roomRepository.save(createRoom(interContinental, 102, 2, RoomType.DOUBLE));
		
		roomRepository.save(createRoom(mariott, 200, 1, RoomType.SINGLE));
		
		customerRepository.save(createCustomer("customer@test.com", "Test customer", 1234567));

		
	}

	private Hotel createHotel(String name, int capacity) {
		Hotel hotel = new Hotel();
		hotel.setName(name);
		hotel.setCapacity(capacity);
		return hotel;
	}

	private Room createRoom(Hotel hotel, int roomNumber, int numberOfBeds, RoomType roomType) {
		Room room = new Room();
		room.setHotel(hotel);
		room.setRoomNumber(roomNumber);
		room.setNumberOfBeds(numberOfBeds);
		room.setRoomType(roomType);
		return room;
	}
	
	private Customer createCustomer(String email, String name, int phone) {
		PrivateCustomer customer = new PrivateCustomer();
		customer.setEmail(email);
		customer.setName(name);
		customer.setPhone(phone);
		customer.setFullName("Full name of my private customer");
		return customer;
	}

}
