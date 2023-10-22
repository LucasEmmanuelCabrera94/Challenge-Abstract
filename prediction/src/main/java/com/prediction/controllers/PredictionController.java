package com.prediction.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prediction.model.entities.Forecast;
import com.prediction.repositories.PredictionRepository;

@RestController
public class PredictionController {

    @Autowired
    private PredictionRepository predictionRepository;
    
   @RequestMapping("/weather")
   public Forecast weather(@RequestParam(value="day") String day) {
           Forecast forecast = predictionRepository.getForecastByDay(Integer.valueOf(day).intValue());
           forecast.setDay(Integer.valueOf(day).intValue());
           return forecast;
   }
}