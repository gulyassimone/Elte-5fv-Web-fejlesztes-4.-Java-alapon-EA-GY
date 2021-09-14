package hu.elte.javaweb._ora_hotel.view;

import hu.elte.javaweb._ora_hotel.domain.Hotel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BasicHotelView implements HotelView {

    @Value("${application-name}")
    private String appName;

    @Override
    public void printDetails(Hotel hotel){
        System.out.println("Hotel details:");
        System.out.printf("Id: %d %n", hotel.getId());
        System.out.printf("Name: %s %n", hotel.getName());
        System.out.printf("Capacity: %d %n", hotel.getCapacity());
    }

    @Override
    public void printWelcomeMessage(){
        System.out.printf("Welcome %s%n:", appName);
    }


}
