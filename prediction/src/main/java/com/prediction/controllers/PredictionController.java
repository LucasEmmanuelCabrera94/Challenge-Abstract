package com.prediction.controllers;

import com.prediction.model.entities.response.QuestionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prediction.model.entities.Forecast;
import com.prediction.repositories.PredictionRepository;
import com.prediction.services.QuestionsService;

@RestController
public class PredictionController {

    @Autowired
    private PredictionRepository predictionRepository;

    @Autowired
    private QuestionsService questionsService;
    
   @RequestMapping("/clima")
   public Forecast weather(@RequestParam(value="dia") String day) {
           return predictionRepository.getForecastByDay(Integer.parseInt(day));
   }
       
   @RequestMapping("/pregunta")
   public QuestionResponse questionOne(@RequestParam(value="id") String id) {
       return questionsService.getQuestionResponse(Long.parseLong(id));
   }
}