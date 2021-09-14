package hu.elte.javaweb._ora_hotel.view;

import hu.elte.javaweb._ora_hotel.domain.Hotel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
//@Primary
public class AdvancedHotelView implements HotelView {

    @Value("${application-name}")
    private String appName;

    private final String border;

    public AdvancedHotelView(String border) {
        this.border = border;
    }

    @Override
    public void printDetails(Hotel hotel){
        System.out.println(border);
        System.out.println("Hotel details:");
        System.out.printf("Id: %d %n", hotel.getId());
        System.out.printf("Name: %s %n", hotel.getName());
        System.out.printf("Capacity: %d %n", hotel.getCapacity());
        System.out.println(border);
    }

    @Override
    public void printWelcomeMessage(){
        System.out.printf("Welcome %s%n:", appName);
    }


}
