package com.prediction.services.InitializerService;

import com.prediction.repositories.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prediction.model.entities.Forecast;
import com.prediction.model.entities.Planet;
import com.prediction.model.entities.Point;
import com.prediction.model.entities.Triangle;
import com.prediction.model.entities.Weather;
import com.prediction.repositories.PredictionRepository;

@Service
public class InitializerServiceImpl implements InitializerService {
    @Autowired
	PredictionRepository predictionRepository;

    @Autowired
    WeatherRepository weatherRepository;

    private Planet planet;
    private Planet planet2;
    private Planet planet3;

    private Weather weather;
    
    private int daysOfDrought = 0;
    private int rainyDays = 0;
    private int optimalDays = 0; 

    @Override
    @Transactional(readOnly = true)
    public void init(Planet planet, Planet planet2, Planet planet3, PredictionRepository predictionRepository, WeatherRepository weatherRepository) {
        this.planet = planet;
        this.planet2 = planet2;
        this.planet3 = planet3;
        this.weatherRepository = weatherRepository;
        this.predictionRepository = predictionRepository;
        this.weather =  new Weather();

        predictionRepository.deleteAll();

        //el enunciado no dice cuantos dias tiene un año de cada planeta, lo igualo a la tierra
        int daysOfYear = 365 * 10;
        for(int i = 0; i < daysOfYear; i++) {
        	predictionRepository.save(getForecast(i));
        }

        Weather galaxyWeather = new Weather(daysOfDrought, rainyDays, optimalDays, this.weather.getDayMaxPeak(), this.weather.getMaxPeak());
        weatherRepository.save(galaxyWeather);
    }

    public Weather getWeather() {
        return this.weather;
    }
    
    public Forecast getForecast(int dayPointer) {				
        Point SunPosition = new Point(0, 0);

        Triangle triangle = Triangle.builder().vertex1(planet.obtainPosition(dayPointer))
                                              .vertex2(planet2.obtainPosition(dayPointer))
                                              .vertex3(planet3.obtainPosition(dayPointer))
                                              .build();

        if (triangle.arePlanetsAligned() && triangle.alignedWithTheSun(SunPosition)) {
            daysOfDrought++;
            return new Forecast("sequia" ,dayPointer, triangle.getPerimeter());
        } else if (!triangle.alignedWithTheSun(SunPosition)) {
            optimalDays++;
            return new Forecast("óptimo de presión y temperatura", dayPointer, triangle.getPerimeter());
        } else if (triangle.pointContainedInTriangle(SunPosition) && !triangle.arePlanetsAligned()) {
            rainyDays++;
            weather.setMaxPeak(triangle.getPerimeter(), dayPointer);
            return new Forecast("lluvia", dayPointer, triangle.getPerimeter());
        } 
        return null;
	}
}
