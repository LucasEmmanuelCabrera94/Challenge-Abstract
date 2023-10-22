package com.prediction.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Planet {
    private Long id;
	private String name;
	private int velocityPerDay;
	private boolean inClockWise;
	private float distance;
}
