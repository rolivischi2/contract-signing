package com.example.demo.endpoint;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myPath")
public class CarEndpoint {

    private final CarService carService;

    public CarEndpoint(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("/{id}")
    Car getOneCar(@PathVariable String id){
        return carService.getOneCar(id);
    }

    @GetMapping
    List<Car> getCars(){
        return carService.getCars();
    }

    @PostMapping
    Car postCar(@RequestBody Car car){
        return carService.postCar(car);
    }

    @PutMapping("/{id}")
    Car putCar(@PathVariable String id, @RequestBody Car car){
        return carService.putCar(id, car);
    }


    @DeleteMapping("/{id}")
    void deleteCar(@PathVariable String id){
        carService.deleteCar(id);
    }


}
