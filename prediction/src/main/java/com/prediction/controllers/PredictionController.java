package com.prediction.controllers;

import com.prediction.model.entities.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prediction.model.entities.Forecast;
import com.prediction.repositories.PredictionRepository;
import com.prediction.repositories.WeatherRepository;
import com.prediction.services.QuestionsService;

@RestController
public class PredictionController {

    @Autowired
    private PredictionRepository predictionRepository;

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private QuestionsService questionsService;
    
   @RequestMapping("/weather")
   public Forecast weather(@RequestParam(value="day") String day) {
           Forecast forecast = predictionRepository.getForecastByDay(Integer.parseInt(day));
           return forecast;
   }
       
   @RequestMapping("/pregunta")
   public Weather questionOne(@RequestParam(value="id") String id) {
           Weather weather =  weatherRepository.getWeatherById(Long.parseLong(id));
           return weather;
   }
         
  /* @RequestMapping("/pregunta/2")
   public String questionTwo() {
           return questionsService.getQuestionTwo();
   }
         
   @RequestMapping("/pregunta/3")
   public String questionThree() {
           return questionsService.getQuestionThree();
   }*/

}