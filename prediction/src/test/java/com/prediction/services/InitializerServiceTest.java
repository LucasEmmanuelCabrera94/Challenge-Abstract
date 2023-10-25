package com.prediction.services;

import com.prediction.model.entities.Planet;
import com.prediction.repositories.PredictionRepository;
import com.prediction.repositories.WeatherRepository;
import com.prediction.services.InitializerService.InitializerServiceImpl;
import com.prediction.utils.Builders;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InitializerServiceTest {
    @Mock
    PredictionRepository predictionRepository;

    @Mock
    WeatherRepository weatherRepository;

    private Planet ferengi;
    private Planet betasoide;
    private Planet vulcano;

    @Before
    public void setUp(){
        this.ferengi = new Planet(1L,"Ferengi", 500, true, 1);
        this.betasoide = new Planet(2L,"Betasoide", 2000, true, 3);
        this.vulcano = new Planet(3L,"Vulcano", 1000, false, 5);
    }

    @Test
    public void initializerTest(){
        InitializerServiceImpl initializerServiceImpl = new InitializerServiceImpl();
        initializerServiceImpl.initializer(ferengi, betasoide, vulcano, predictionRepository, weatherRepository);
    }
}
