package hu.elte.javaweb._ora_hotel;

import hu.elte.javaweb._ora_hotel.domain.Hotel;
import hu.elte.javaweb._ora_hotel.service.HotelService;
import hu.elte.javaweb._ora_hotel.view.AdvancedHotelView;
import hu.elte.javaweb._ora_hotel.view.BasicHotelView;
import hu.elte.javaweb._ora_hotel.view.HotelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);

		//HotelApplication hotelApplication = new HotelApplication(); //Ha konstruktorral hozom létre, akkor nem fogja garantálni a függőséget.
		//hotelApplication.play();
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){ //spring konténer, kivehetünk egy konkrét beant
		return args -> {
			//ctx.getBean(HotelApplication.class).play(); //közvetlenül kiveszi
			hotelApplication.play();
			System.out.println(ctx.getBean(HotelService.class));
			System.out.println(ctx.getBean(HotelService.class));
			System.out.println(hotelService);
		};
	}
	/*public  HotelApplication(){
		this.hotelService = new HotelService();
		this.hotelView = new HotelView();
	} // autowired miatt nem szükséges
	*/



	public void play() {

		hotelView.printWelcomeMessage();

		Hotel hotel1= hotelService.findById(1);
		hotelView.printDetails(hotel1);

		Hotel hotel2 = hotelService.findById(2);
		hotelView.printDetails(hotel2);


	}

}
/*
Beaneknek lehetnek különböző szkópjai.
	- Singleton - akárhoz injektálom, mindig ugyanazt a példányt fogom kapni - alapértelmezett
	- másik megoldás ritka
 */