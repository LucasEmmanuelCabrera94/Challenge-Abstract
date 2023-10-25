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
	private double distance;

	/**
	 * the position of a planet is obtained.
	 * @return a Point with the position.
	 */
	public Point obtainPosition(int day) {
		//result in negative or positive
		int direction = (inClockWise)? 1 : -1;
		int totalGrade = 360;

		double positionInGrade = (day * this.velocityPerDay * direction) % totalGrade;
		double positionInRadio = Math.toRadians(positionInGrade);
		
		double x = Math.cos(positionInRadio) * this.distance;
		double y = Math.sin(positionInRadio) * this.distance;

		return new Point(x, y);
	}
}
