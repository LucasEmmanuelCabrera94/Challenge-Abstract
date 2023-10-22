package com.prediction;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.prediction.repositories.PredictionRepository;
import com.prediction.services.InitializerService.InitializerServiceImpl;
import com.prediction.utils.Builders;

@SpringBootApplication
public class PredictionApplication {

    public static void main(String[] args) {
		//Build Context
		SpringApplication.run(PredictionApplication.class, args);
	}

	@Bean
	public CommandLineRunner setup(PredictionRepository predictionRepository) {
		return (args) -> {
			Builders buildInit = new Builders();
			buildInit.init(predictionRepository);
			new InitializerServiceImpl();
		};
	}
}
