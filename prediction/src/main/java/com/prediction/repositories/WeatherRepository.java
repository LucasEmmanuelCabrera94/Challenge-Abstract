package com.prediction.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.prediction.model.entities.Weather;

@Repository("weatherRepository")
public interface WeatherRepository extends CrudRepository<Weather, Long> {
   public Weather getWeatherById(long id);
}
