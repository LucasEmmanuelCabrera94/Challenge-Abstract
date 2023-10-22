package com.prediction.model.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
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
	public Long getId() {
		return id;
	}
	public String getWeather() {
		return weather;
	}
	public int getDay() {
		return day;
	}
	public double getPerimeter() {
		return perimeter;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}
}

