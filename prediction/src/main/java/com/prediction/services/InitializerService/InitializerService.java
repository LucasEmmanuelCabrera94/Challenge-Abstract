package com.prediction.services.InitializerService;

import com.prediction.model.entities.Planet;
import com.prediction.repositories.PredictionRepository;

public interface InitializerService {
    void init(Planet planet, Planet planet2, Planet planet3, PredictionRepository predictionRepository);
}
