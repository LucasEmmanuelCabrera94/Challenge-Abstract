package com.prediction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


import com.prediction.model.entities.Forecast;

@Repository("pronosticoRepository")
public interface PredictionRepository extends CrudRepository<Forecast, Long> {
   public Forecast getForecastByDay(int day);
}
