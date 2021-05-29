package com.example.demo.service;

import com.example.demo.model.Car;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {

    private MyBean myBean;
    private List<Integer> numbers;
    private String name;
    private List<Car> cars;

    public MyBean getMyBean() {
        return myBean;
    }

    public void setMyBean(MyBean myBean) {
        this.myBean = myBean;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }


    public MyService(MyBean myBean,
                     @Value("${app.numbers}") List<Integer> numbers,
                     @Value("${app.name}") String name, List<Car> cars) {
        this.myBean = myBean;
        this.numbers = numbers;
        this.name = name;
        this.cars = cars;
    }
}
