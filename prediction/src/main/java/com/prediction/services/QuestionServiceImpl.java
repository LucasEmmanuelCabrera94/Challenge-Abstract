package com.prediction.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prediction.services.InitializerService.InitializerService;

@Service
public class QuestionServiceImpl implements QuestionsService {
    @Autowired
    private InitializerService initializerService;

    @Override
    public String getQuestionOne() {
        return initializerService.getWeather().getDaysOfDrought();
    }

    @Override
    public String getQuestionTwo() {
        return "Pregunta 2";
    }

    @Override
    public String getQuestionThree() {
        return "Pregunta 3";
    }
    
}
