package com.prediction;

import com.prediction.repositories.WeatherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.prediction.repositories.PredictionRepository;
import com.prediction.utils.Builders;

@SpringBootApplication
public class PredictionApplication {

    public static void main(String[] args) {
		//Build Context
		SpringApplication.run(PredictionApplication.class, args);
	}

	@Bean
	public CommandLineRunner setup(PredictionRepository predictionRepository, WeatherRepository weatherRepository) {
		return (args) -> {
			Builders buildInit = new Builders();
			buildInit.initializer(predictionRepository, weatherRepository);
		};
	}
}
