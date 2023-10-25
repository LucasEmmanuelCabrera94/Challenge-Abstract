package com.prediction.services;

import com.prediction.model.entities.response.QuestionResponse;
import com.prediction.repositories.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionsService {
    private String defaultResponse = "Solo se pueden seleccionar del 1 al 3 como ID";
    @Autowired
    private WeatherRepository weatherRepository;

    public QuestionResponse getQuestionResponse(long id) {
        String response;
        return switch ((int) id) {
            case 1 -> {
                response = weatherRepository.getWeatherById(1).getDaysOfDrought();
                yield QuestionResponse.builder().response(response).build();
            }
            case 2 -> {
                response = weatherRepository.getWeatherById(1).getRainyDays();
                yield QuestionResponse.builder().response(response).build();
            }
            case 3 -> {
                response = weatherRepository.getWeatherById(1).getOptimalDays();
                yield QuestionResponse.builder().response(response).build();
            }
            default -> QuestionResponse.builder().response(defaultResponse).build();
        };
    }
}
