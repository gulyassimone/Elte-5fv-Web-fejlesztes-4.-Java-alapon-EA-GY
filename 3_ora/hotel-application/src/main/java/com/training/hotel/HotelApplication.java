package com.training.hotel;

import com.training.hotel.application.service.HotelService;
import com.training.hotel.application.service.TestdataGenerator;
import com.training.hotel.application.view.HotelView;
import com.training.hotel.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication //Ha ezt elindítom akkor a main függvény fog elindulni
public class HotelApplication {

	@Autowired
	private HotelService hotelService;

	@Autowired
	//@Qualifier("basicHotelView")
	private HotelView hotelView; // név alapján vagy típus alapján azonosít, vagy primary Component , vagy annotációval, de a legjobb a konfigurációs fájl

	@Autowired
	private HotelApplication hotelApplication;

	@Autowired
	private TestdataGenerator testdataGenerator;



	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);

		//HotelApplication hotelApplication = new HotelApplication(); //Ha konstruktorral hozom létre, akkor nem fogja garantálni a függőséget.
		//hotelApplication.play();
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){ //spring konténer, kivehetünk egy konkrét beant
		return args -> {
			testdataGenerator.createTestData();
			//ctx.getBean(HotelApplication.class).play(); //közvetlenül kiveszi
			hotelApplication.play();
		};
	}
	/*public  HotelApplication(){
		this.hotelService = new HotelService();
		this.hotelView = new HotelView();
	} // autowired miatt nem szükséges
	*/



	public void play() {

		hotelView.printWelcomeMessage();
 		hotelService.findAllHotel().forEach(hotelView::printDetails);

 		hotelView.println("Please select a hotel!");
 		int hotelId = hotelView.readInt();
 		hotelView.println("Selected hotel: " + hotelId);

		hotelService.findAllRoomsByHotelId(hotelId).forEach(hotelView::printDetails);

		int roomId = hotelView.readInt();
		hotelView.println("Selected room: " + roomId);

		Reservation saveReservation =hotelService.saveReservation(roomId);
		hotelView.println("Reservation saved: " + saveReservation.getId());
	}

}
/*
Beaneknek lehetnek különböző szkópjai.
	- Singleton - akárhoz injektálom, mindig ugyanazt a példányt fogom kapni - alapértelmezett
	- másik megoldás ritka
 */