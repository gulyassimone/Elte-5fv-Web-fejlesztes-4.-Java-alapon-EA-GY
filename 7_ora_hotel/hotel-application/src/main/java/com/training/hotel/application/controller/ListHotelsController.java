package com.training.hotel.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.training.hotel.application.service.HotelService;
import com.training.hotel.application.webdomain.HotelListView;

@Controller
public class ListHotelsController {

	@Autowired
	private HotelService hotelService;
	
	
	@GetMapping("hotels")
	public String listHotels(Model model) {
		List<HotelListView> hotelListViews = new ArrayList<>();
		
		hotelService.findAllHotel().forEach(h 
				-> hotelListViews.add(new HotelListView(h.getId(), h.getName(), h.getCapacity())));
		
		model.addAttribute("hotels", hotelListViews);		
		return "hotels";

	}
}
