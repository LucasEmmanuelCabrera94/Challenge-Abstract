package com.prediction.services.InitializerService;

import com.prediction.model.entities.Planet;
import com.prediction.repositories.PredictionRepository;
import com.prediction.repositories.WeatherRepository;

public interface InitializerService {
    void initializer(Planet planet, Planet planet2, Planet planet3, PredictionRepository predictionRepository, WeatherRepository weatherRepository);
}
