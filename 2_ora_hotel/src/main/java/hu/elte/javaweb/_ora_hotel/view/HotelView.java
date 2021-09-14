package hu.elte.javaweb._ora_hotel.view;

import hu.elte.javaweb._ora_hotel.domain.Hotel;
import org.springframework.stereotype.Component;

@Component
public interface HotelView {
    void printDetails(Hotel hotel);

    void printWelcomeMessage();
}
