package com.prediction.services.InitializerService;

import com.prediction.model.entities.Planet;
import com.prediction.model.entities.Weather;
import com.prediction.repositories.PredictionRepository;
import com.prediction.repositories.WeatherRepository;
import org.springframework.transaction.annotation.Transactional;

public interface InitializerService {
    void init(Planet planet, Planet planet2, Planet planet3, PredictionRepository predictionRepository, WeatherRepository weatherRepository);

    Weather getWeather();
}
