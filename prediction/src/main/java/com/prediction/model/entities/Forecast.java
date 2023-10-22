package com.prediction.model.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("forecast")
@JsonIgnoreProperties("perimeter")
public class Forecast {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String weather;
	private int day;
	private double perimeter;

	public Forecast() {}
}

