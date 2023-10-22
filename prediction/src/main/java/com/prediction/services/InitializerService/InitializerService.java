package com.prediction.services.InitializerService;

import com.prediction.repositories.PredictionRepository;

public interface InitializerService {
    void init(PredictionRepository predictionRepository);
}
