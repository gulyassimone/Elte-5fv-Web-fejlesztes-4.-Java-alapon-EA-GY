package com.training.hotel.application.configuration;


import com.training.hotel.application.view.AdvancedHotelView;
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
