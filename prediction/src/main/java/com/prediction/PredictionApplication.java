package com.prediction;

import com.prediction.model.entities.Planet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.sql.*;

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
			//Builders buildInit = new Builders();
			//buildInit.init(predictionRepository);
			//new InitializerServiceImpl();

		// 	  String jdbcUrl = "jdbc:h2:mem:testdb";

        // // Credenciales de la base de datos (usuario y contraseña)
        // String usuario = "usuario";
        // String contraseña = "contraseña";

        // try {
        //     // Cargar el controlador JDBC de H2
        //     Class.forName("org.h2.Driver");

        //     // Establecer la conexión a la base de datos en memoria
        //     Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña);

        //     // Crear una tabla de ejemplo
        //     Statement statement = connection.createStatement();
		// 	String createTableSQL = "CREATE TABLE forecast (id INT PRIMARY KEY, \"day\" VARCHAR(255), perimeter DOUBLE, weather VARCHAR(255))";
		// 	statement.execute(createTableSQL);

        //     // Insertar datos de ejemplo
		// 	String insertDataSQL = "INSERT INTO forecast (id, \"day\", perimeter, weather) VALUES (1, 'Monday', 10.5, 'Sunny')";
        //     statement.executeUpdate(insertDataSQL);

        //     // Realizar una consulta
        //     String selectDataSQL = "SELECT * FROM forecast";
        //     var resultSet = statement.executeQuery(selectDataSQL);

        //     // Mostrar los resultados de la consulta
        //     while (resultSet.next()) {
        //         int id = resultSet.getInt("id");
        //         String day = resultSet.getString("day");
        //         double perimeter = resultSet.getDouble("perimeter");
        //         String weather = resultSet.getString("weather");
        //         System.out.println("ID: " + id + ", Day: " + day + ", Perimeter: " + perimeter + ", Weather: " + weather);
        //     }

        //     // Cerrar la conexión y liberar recursos
        //     resultSet.close();
        //     statement.close();
        //     connection.close();
        // } catch (ClassNotFoundException | SQLException e) {
        //     e.printStackTrace();
        // }

			Planet ferengi = Planet.builder().name("Ferengi")
					.velocityPerDay(500)
					.inClockWise(true)
					.distance(1)
					.build();;
			Planet betasoide = Planet.builder().name("Betasoide")
					.velocityPerDay(2000)
					.inClockWise(true)
					.distance(3)
					.build();
			Planet vulcano = Planet.builder().name("Vulcano")
					.velocityPerDay(1000)
					.inClockWise(false)
					.distance(5)
					.build();

			InitializerServiceImpl prueba = new InitializerServiceImpl();
			prueba.init(ferengi,betasoide,vulcano,predictionRepository);
		};
	}
}
