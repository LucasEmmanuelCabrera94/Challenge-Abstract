package com.prediction.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.prediction.model.entities.Forecast;

@Repository("predictionRepository")
public interface PredictionRepository extends CrudRepository<Forecast, Long> {
   public Forecast getForecastByDay(int day);
}
