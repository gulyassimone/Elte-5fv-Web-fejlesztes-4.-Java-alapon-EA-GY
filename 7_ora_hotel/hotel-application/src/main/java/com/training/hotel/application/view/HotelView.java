package com.training.hotel.application.view;

import com.training.hotel.domain.Hotel;
import com.training.hotel.domain.Room;

public interface HotelView {

	void printDetails(Hotel hotel);

	void printWelcomeMessage();

	void printDetails(Room room);

	void println(String msg);

	int readInt();

}