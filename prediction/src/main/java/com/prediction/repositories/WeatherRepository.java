package com.prediction.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.prediction.model.entities.Weather;

@Repository("wheaterRepository")
public interface WeatherRepository extends CrudRepository<Weather, Long> {
   public Weather getWheater(int day);
}
