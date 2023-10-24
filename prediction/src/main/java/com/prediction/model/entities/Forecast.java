package com.prediction.model.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "forecast")
public class Forecast {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String weather;
	@Column(name = "\"day\"")
	private int day;
	private double perimeter;

	public Forecast(){}

	public Forecast(String weather, int day, double perimeter) {
		super();
		this.weather = weather;
		this.day = day;
		this.perimeter = perimeter;
	}

}

