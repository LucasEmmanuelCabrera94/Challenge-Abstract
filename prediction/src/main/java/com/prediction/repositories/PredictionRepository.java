package com.prediction.repositories;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;


import com.prediction.model.entities.Forecast;

@Repository
public interface PredictionRepository extends PagingAndSortingRepository<Forecast, Long> {
   public Forecast getForecastByDay(int day);

}
