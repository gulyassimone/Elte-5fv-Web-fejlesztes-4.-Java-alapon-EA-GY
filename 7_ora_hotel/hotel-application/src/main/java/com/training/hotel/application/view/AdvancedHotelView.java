package com.training.hotel.application.view;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;

import com.training.hotel.domain.Hotel;
import com.training.hotel.domain.Room;

public class AdvancedHotelView implements HotelView {

	@Value("${application-name}")
	private String appName;
	
	private final String border;
	
	private final Scanner scanner; 

	public AdvancedHotelView(String border) {
		this.border = border;
		scanner = new Scanner(System.in);
	}

	@Override
	public void printDetails(Hotel hotel) {
		System.out.println(border);
		System.out.println("Hotel details:");
		System.out.printf("Id: %s %n", hotel.getId());
		System.out.printf("Name: %s %n", hotel.getName());
		System.out.printf("Capacity: %s %n", hotel.getCapacity());
		System.out.printf("Rooms: %s %n", hotel.getRooms().size());
		System.out.println(border);
	}

	@Override
	public void printDetails(Room room) {
		System.out.println(border);
		System.out.println("Room details:");
		System.out.printf("Id: %s %n", room.getId());
		System.out.printf("Room number: %s %n", room.getRoomNumber());
		System.out.printf("Room type: %s %n", room.getRoomType());
		System.out.printf("Number of beds: %s %n", room.getNumberOfBeds());
		System.out.println(border);

	}
	
	@Override
	public void println(String msg) {
		System.out.println(msg);
	}
	
	@Override
	public int readInt() {
		return scanner.nextInt();
	}
	
	@Override
	public void printWelcomeMessage() {
		System.out.printf("Welcome %s%n", appName);
	}
}