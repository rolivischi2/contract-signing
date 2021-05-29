package com.example.demo.controller;

import com.example.demo.model.Car;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class CarClient {

    private final RestTemplate restTemplate;
    private final String url;

    public CarClient(RestTemplate restTemplate, @Value("${api.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public Car getOneCar(String id){
        return restTemplate.getForObject(url + "/" + id, Car.class);
    }

    public Car[] getCars(){
        return restTemplate.getForObject(url, Car[].class);
    }

    public Car postCar(Car car){
        return restTemplate.postForObject(url, car, Car.class);
    }

    public Car putCar(String id,Car car){
        restTemplate.put(url + "/" + id, car);
        return car;
    }

    public void deleteCar(String id){
        restTemplate.delete(url + "/" + id);
    }
}
