package com.prediction.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "weather")
public class Weather {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"id\"")
	private Long id;
	private int daysOfDrought;
	private int rainyDays;
	private int optimalDays;
	private int dayMaxPeak;
	private double maxPeak;

	public Weather(){}

	public Weather(int daysOfDrought, int rainyDays, int optimalDays, int dayMaxPeak, double maxPeak) {
		super();
		this.daysOfDrought = daysOfDrought;
		this.rainyDays = rainyDays;
		this.optimalDays = optimalDays;
		this.dayMaxPeak = dayMaxPeak;
		this.maxPeak = maxPeak;
	}

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
