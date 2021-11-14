package com.training.hotel.application.webdomain;

public class HotelListView {

	private final int id;
	private final String name;
	private final int capacity;

	public HotelListView(int id, String name, int capacity) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getCapacity() {
		return capacity;
	}
	
	

}
