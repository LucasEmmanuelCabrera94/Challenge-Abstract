package com.prediction.services.InitializerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prediction.model.entities.Forecast;
import com.prediction.model.entities.Planet;
import com.prediction.model.entities.Point;
import com.prediction.model.entities.Triangle;
import com.prediction.repositories.PredictionRepository;

@Service
public class InitializerServiceImpl implements InitializerService {
    @Autowired
	PredictionRepository predictionRepository; 

    private final int daysOfYear = 365; //el enunciado no dice cuantos dias tiene un año de cada planeta, lo igualo a la tierra
    private Planet planet;
    private Planet planet2;
    private Planet planet3;

    @Override
    @Transactional(readOnly = true)
    public void init(Planet planet, Planet planet2, Planet planet3, PredictionRepository predictionRepository) {
        //depedency injection 
        this.planet = planet;
        this.planet2 = planet2;
        this.planet3 = planet3;
        this.predictionRepository = predictionRepository;


        for(int i = 0; i < daysOfYear; i++) {
        	predictionRepository.save(getForecast(i));
        }
    }

    public Forecast getForecast(int dayPointer) {				
        Triangle triangle = Triangle.builder().vertex1(planet.obtainPosition(dayPointer))
                                              .vertex2(planet2.obtainPosition(dayPointer))
                                              .vertex3(planet3.obtainPosition(dayPointer))
                                              .build();

        Point SunPosition = new Point(0, 0);
        
        if(triangle.pointContainedInTriangle(planet.obtainPosition(dayPointer)) && triangle.getArea() == 0) { 
            if(triangle.pointContainedInTriangle(SunPosition)) {
                //los tres planetas están alineados entre sí y alineados con respecto al sol = sequía
                return new Forecast("sequia" ,dayPointer, triangle.getPerimeter());
            } else {
                //los tres planetas están alineados entre sí, pero no están alineados con el sol = óptimas de presión y temperatura
                return new Forecast("optimo de presión y temperatura", dayPointer, triangle.getPerimeter());
            }
        } else if (triangle.pointContainedInTriangle(SunPosition)) {
                // el sol se encuentra dentro del triángulo y  los tres planetas no están alineados = lluvia
                return new Forecast("lluvia", dayPointer, triangle.getPerimeter());
        }

        return new Forecast("soleado", dayPointer, triangle.getPerimeter());
	}
    
}
