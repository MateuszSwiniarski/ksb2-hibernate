package com.rodzyn.ksb2hibernate.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {

    private CarRepository carRepository;

    @Autowired
    public Start(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void Start(){
        Car carPolonez = new Car("Polonez", "Caro", Color.RED);
        Car carFiat = new Car("Fiat", "Panda", Color.BLACK);
        Car carBmw = new Car("BMW", "i8", Color.BLACK);
        Car carFiat126 = new Car("Fiat", "126p", Color.BLUE);

        carRepository.save(carPolonez);
        carRepository.save(carFiat);
        carRepository.save(carBmw);
        carRepository.save(carFiat126);

        carRepository.findCarsByColor(Color.BLACK).forEach(System.out::println);
        carRepository.findCarsByColorAndMark(Color.BLACK, "Fiat").forEach(System.out::println);
    }
}
