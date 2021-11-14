package com.training.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.training.hotel.application.service.HotelService;
import com.training.hotel.application.service.TestDataGenerator;
import com.training.hotel.application.view.HotelView;
import com.training.hotel.domain.Reservation;

@SpringBootApplication
public class HotelApplication {

	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private HotelView hotelView;
	
//	@Autowired
//	private HotelApplication hotelApplication;
	
	@Autowired
	private TestDataGenerator testDataGenerator;
	
	
	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) { 
        return args -> {
        	testDataGenerator.createTestData();
            //hotelApplication.play(); 
            
        }; 
    } 
	
	
	public void play() {
		hotelView.printWelcomeMessage();
		
		while (true) {
			hotelService.findAllHotel().forEach(hotelView::printDetails);
			hotelView.println("Please select a hotel!");
			
			int hotelId = hotelView.readInt();
					
			hotelView.println("Selected hotel: " + hotelId);
			
			hotelService.findAllRoomsByHotelId(hotelId).forEach(hotelView::printDetails);
			
			hotelView.println("Please select a room!");
			int roomId = hotelView.readInt();
			
			hotelView.println("Selected room: " + roomId);
			
			Reservation reservation = hotelService.saveReservation(roomId);
			hotelView.println("Reservation saved: " + reservation.getId());
		}
		
	}
	

}
