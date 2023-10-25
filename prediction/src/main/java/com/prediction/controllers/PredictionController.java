package com.prediction.controllers;

import com.prediction.model.entities.response.ForecastResponse;
import com.prediction.model.entities.response.QuestionResponse;
import com.prediction.validators.ValidatorController;
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

    @Autowired
    private ValidatorController validatorController;
    
   @RequestMapping("/clima")
   public ForecastResponse weather(@RequestParam(value="dia") int dia) {
       try {
           validatorController.validateRequestParam(dia);
       } catch (IllegalAccessException iae){
           return ForecastResponse.builder().error(iae.getMessage()).build();
       }
       Forecast response = predictionRepository.getForecastByDay(dia);
       return ForecastResponse.builder().forecast(response).build();
   }
       
   @RequestMapping("/pregunta")
   public QuestionResponse questionOne(@RequestParam(value="id") String id) {
       return questionsService.getQuestionResponse(Long.parseLong(id));
   }
}