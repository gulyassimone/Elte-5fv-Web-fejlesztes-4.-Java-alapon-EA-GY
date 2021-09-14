package hu.elte.javaweb._ora_hotel.configuration;

import hu.elte.javaweb._ora_hotel.view.AdvancedHotelView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class HotelConfiguration {

    @Bean
    public AdvancedHotelView advancedHotelViewWithPlus(){
        return  new AdvancedHotelView("++++++++++++++++++++++++++++++");
    }

    @Bean
    @Primary
    public AdvancedHotelView advancedHotelViewWithMinus(){
        return new AdvancedHotelView("---------------------------------");
    }
}
