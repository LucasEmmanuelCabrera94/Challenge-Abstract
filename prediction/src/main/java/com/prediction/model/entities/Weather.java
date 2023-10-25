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

	public String getDaysOfDrought() {
		return String.format("En 10 años habrá %d periodos de sequía", this.daysOfDrought);
	}
	public String getRainyDays() {
		return String.format("En 10 años habrá %d periodos de lluvia y el dia %d habra un pico máximo de lluvia", this.rainyDays, this.dayMaxPeak);
	}
	public String getOptimalDays() {
		return String.format("En 10 años habrá %d periodos de condiciones óptimas de presión y temperatura", this.optimalDays);
	}
}
