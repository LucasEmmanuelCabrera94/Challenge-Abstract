package com.prediction.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "weather")
public class Weather {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private int daysOfDrought;
	private int rainyDays;
	private int optimalDays;
	private int dayMaxPeak;
	private double maxPeak;

	public void setMaxPeak(double perimeter, int day){
		if (maxPeak < perimeter) {
			maxPeak = perimeter;
			dayMaxPeak = day;
		}
	}

	public String getRainyDays() {
		return "prueba rainy";
	}
	public String getOptimalDays() {
		return "prueba optimal";
	}
	public String getDaysOfDrought() {
		return "prueba drought";
	}
}
