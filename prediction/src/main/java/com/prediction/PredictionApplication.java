package com.prediction;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.prediction.repositories.PredictionRepository;
import com.prediction.services.InitializerService.InitializerService;
import com.prediction.services.InitializerService.InitializerServiceImpl;

@SpringBootApplication
public class PredictionApplication {
    public static void main(String[] args) {
		//Build Context

		SpringApplication.run(PredictionApplication.class, args);
	}

	@Bean
	public CommandLineRunner setup(PredictionRepository predictionRepository) {
		return (args) -> {
			InitializerService initializer = new InitializerServiceImpl();
			initializer.init(predictionRepository);
		};
	}
}
