package com.prediction.services.InitializerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prediction.repositories.PredictionRepository;

@Service
public class InitializerServiceImpl implements InitializerService {
    @Autowired
	PredictionRepository predictionRepository; 

    @Override
    public void init(PredictionRepository predictionRepository) {
        this.predictionRepository=predictionRepository;
    }
    
}
