package com.training.hotel.application.view;


import com.training.hotel.domain.Hotel;
import com.training.hotel.domain.Room;
import org.springframework.stereotype.Component;

@Component
public interface HotelView {
    void printDetails(Hotel hotel);
    void printDetails(Room room);

    void printWelcomeMessage();

    void println(String msg);

    int readInt();
}
