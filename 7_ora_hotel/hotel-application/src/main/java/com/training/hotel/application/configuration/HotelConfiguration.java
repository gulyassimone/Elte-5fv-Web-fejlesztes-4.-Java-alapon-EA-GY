package com.training.hotel.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.training.hotel.application.view.AdvancedHotelView;
import com.training.hotel.application.view.HotelView;

@Configuration
public class HotelConfiguration {

	@Bean
	public HotelView advancedHotelViewWithPlus() {
		return new AdvancedHotelView("++++++++++++++++++++++++");
	}

	@Bean
	@Primary
	public HotelView hotelView() {
		return new AdvancedHotelView("------------------------");
	}
}
