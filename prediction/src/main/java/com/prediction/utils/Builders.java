package com.prediction.utils;

import com.prediction.repositories.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.prediction.model.entities.Planet;
import com.prediction.repositories.PredictionRepository;
import com.prediction.services.InitializerService.InitializerService;
import com.prediction.services.InitializerService.InitializerServiceImpl;

public class Builders {
    @Autowired
    private InitializerService initializerService = new InitializerServiceImpl();

    public void initializer(PredictionRepository predictionRepository, WeatherRepository weatherRepository){
        Planet ferengi = Planet.builder().name("Ferengi")
                                        .velocityPerDay(500)
                                        .inClockWise(true)
                                        .distance(1)
                                        .build();;
        Planet betasoide = Planet.builder().name("Betasoide")
                                        .velocityPerDay(2000)
                                        .inClockWise(true)
                                        .distance(3)
                                        .build();
        Planet vulcano = Planet.builder().name("Vulcano")
                                        .velocityPerDay(1000)
                                        .inClockWise(false)
                                        .distance(5)
                                        .build();

        
        initializerService.initializer(ferengi, betasoide, vulcano, predictionRepository, weatherRepository);
    }
}
