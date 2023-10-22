package com.prediction.services;

import com.prediction.model.entities.Forecast;

public interface PredictionService {
    Forecast getForecast(int day);
}
