package com.training.hotel.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.training.hotel.application.service.HotelService;
import com.training.hotel.application.webdomain.AddHotelRequest;
import com.training.hotel.domain.Hotel;

@Controller
public class AddHotelController {


	private static final Logger LOGGER = LoggerFactory.getLogger(AddHotelController.class);

	@Autowired
	private HotelService hotelService;

	@PostMapping("addHotel")
	public String addHotel(AddHotelRequest addHotelRequest) {
		Hotel hotel = new Hotel();
		hotel.setName(addHotelRequest.getName());
		hotel.setCapacity(addHotelRequest.getCapacity());
		
		hotelService.saveHotel(hotel);
		
		LOGGER.info("Hotel [{}] successfully saved.", hotel.getId());
		
		
		return "redirect:hotels";
		
		
	}

}
