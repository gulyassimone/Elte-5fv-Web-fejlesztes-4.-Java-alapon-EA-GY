package com.training.hotel.application.service;

import com.training.hotel.domain.*;
import com.training.hotel.repository.CustomerRepositroy;
import com.training.hotel.repository.HotelRepositroy;
import com.training.hotel.repository.RoomRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TestdataGenerator {

    @Autowired
    private HotelRepositroy hotelRepositroy;

    @Autowired
    private RoomRepositroy roomRepositroy;

    @Autowired
    private CustomerRepositroy customerRepositroy;




    @Transactional
    public void createTestData() {
        Hotel mariott = createHotel("Mariott ***** Superior", 500);
        hotelRepositroy.save(mariott);

        Hotel interContinental = createHotel("Intercontinental ***** Superior", 1500);
        hotelRepositroy.save(interContinental);

        roomRepositroy.save(createRoom(mariott, 200, 1, RoomType.SINGLE));

        roomRepositroy.save(createRoom(interContinental, 101, 1, RoomType.SINGLE));
        roomRepositroy.save(createRoom(interContinental, 102, 2, RoomType.DOUBLE));

        roomRepositroy.save(createRoom(mariott, 200, 1, RoomType.SINGLE));

        customerRepositroy.save(createCustomer("customer@test.com", "Test customer", 1234567));

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
