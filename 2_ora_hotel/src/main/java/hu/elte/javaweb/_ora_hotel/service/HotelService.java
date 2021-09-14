package hu.elte.javaweb._ora_hotel.service;

import hu.elte.javaweb._ora_hotel.domain.Hotel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service // ő egy réteg, vagyis egy komponens
@Scope("prototype") // Ha mindig másmilyen prototípust hozok létre
public class HotelService {

    public static int counter = 0;
    private final int serviceId;

    public HotelService() {
        this.serviceId = counter++;
    }


    public Hotel findById(int id) {
        Hotel hotel = new Hotel();
        hotel.setId(id);
        if (id == 1) {
            hotel.setName("Mariott ***** Superior");
            hotel.setCapacity(500);

        }
        else if(id == 2){
            hotel.setName("Intercontinental ***** Superior");
            hotel.setCapacity(1500);
        }
        else{
            throw new IllegalArgumentException("Hotel [" + id + "] does not exists.");
        }
        return hotel;
    }

    @Override
    public String toString() {
        return "HotelService{" +
                "serviceId=" + serviceId +
                '}';
    }
}
