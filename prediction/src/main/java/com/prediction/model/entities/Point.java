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
public class Point {
    private double x;
    private double y;

    public double getDistance (Point point){
		return Math.sqrt(Math.pow(point.getX()-this.x, 2) + Math.pow(point.getY()-this.y, 2));
	}
}
