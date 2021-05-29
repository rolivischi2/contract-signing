package com.example.demo.configuration;

import com.example.demo.model.Car;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("complex")
public class CarConfiguration {
    private List<Car> cars;

    @Bean
    List<Car> cars(){
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
