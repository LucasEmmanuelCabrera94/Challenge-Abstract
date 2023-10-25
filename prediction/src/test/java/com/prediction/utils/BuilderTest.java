package com.prediction.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.prediction.repositories.PredictionRepository;
import com.prediction.repositories.WeatherRepository;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@RunWith(MockitoJUnitRunner.class)
public class BuilderTest {
    @Mock
    private WeatherRepository weatherRepository;

    @Mock
    private PredictionRepository predictionRepository;

    @Test
    public void initializerTest(){
        Builders builder = new Builders();
        assertDoesNotThrow(() -> {
            builder.initializer(predictionRepository, weatherRepository);
        });
    }
}
