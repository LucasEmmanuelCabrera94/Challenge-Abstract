package com.prediction.services;

import com.prediction.model.entities.Weather;
import com.prediction.model.entities.response.QuestionResponse;
import com.prediction.repositories.WeatherRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuestionsServiceTest {
    @Mock
    private WeatherRepository weatherRepository;

    @Mock
    private QuestionServiceImpl questionServiceImpl;

    private Weather galaxyWeather;
    @Before
    public void setUp(){
        this.questionServiceImpl = new QuestionServiceImpl(weatherRepository);
        galaxyWeather = new Weather(10, 20, 50, 27, 1000);
        galaxyWeather.setId(1L);
        this.weatherRepository.save(galaxyWeather);
    }

    @Test
    public void QuestionNumberOneTest(){
        when(weatherRepository.getWeatherById(1)).thenReturn(galaxyWeather);

        QuestionResponse result = this.questionServiceImpl.getQuestionResponse(1);

        QuestionResponse expected = QuestionResponse.builder().response("En 10 años habrá 10 periodos de sequía").build();
        assertNotNull(result);
        assertEquals(result.getResponse(), expected.getResponse());
    }
    @Test
    public void QuestionNumberTwoTest(){
        when(weatherRepository.getWeatherById(1)).thenReturn(galaxyWeather);

        QuestionResponse result = this.questionServiceImpl.getQuestionResponse(2);

        QuestionResponse expected = QuestionResponse.builder().response("En 10 años habrá 20 periodos de lluvia y el dia 27 habra un pico máximo de lluvia").build();
        assertNotNull(result);
        assertEquals(result.getResponse(), expected.getResponse());
    }
    @Test
    public void QuestionNumberThreeTest(){
        when(weatherRepository.getWeatherById(1)).thenReturn(galaxyWeather);

        QuestionResponse result = this.questionServiceImpl.getQuestionResponse(3);

        QuestionResponse expected = QuestionResponse.builder().response("En 10 años habrá 50 periodos de condiciones óptimas de presión y temperatura").build();
        assertNotNull(result);
        assertEquals(result.getResponse(), expected.getResponse());
    }

    @Test
    public void QuestionNumberTenTest(){
        QuestionResponse result = this.questionServiceImpl.getQuestionResponse(10);

        QuestionResponse expected = QuestionResponse.builder().response("Solo se pueden seleccionar del 1 al 3 como ID").build();
        assertNotNull(result);
        assertEquals(result.getResponse(), expected.getResponse());
    }
}
