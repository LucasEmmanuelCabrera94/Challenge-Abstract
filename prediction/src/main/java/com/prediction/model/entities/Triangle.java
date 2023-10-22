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
public class Triangle {
    private Point vertex1;
    private Point vertex2;
    private Point vertex3;

    public boolean pointContainedInTriangle(Point point){
        double triangleAreaOriginal = getArea();
        double area1 = getAreaWithOtherPoint(point, vertex2, vertex3);
        double area2 = getAreaWithOtherPoint(vertex1, point, vertex3);
        double area3 = getAreaWithOtherPoint(vertex1, vertex2, point);

        return (area1 + area2 + area3) == triangleAreaOriginal;
    }

    public double getArea(){
        return Math.abs((vertex1.getX() * (vertex2.getY() - vertex3.getY()) + 
                         vertex2.getX() * (vertex3.getY() - vertex1.getY()) +
                         vertex3.getX() * (vertex1.getY() - vertex2.getY())
                         )/ 2);
    }

    public double getAreaWithOtherPoint(Point point, Point point2, Point point3){
        return Math.abs((vertex1.getX() * (vertex2.getY() - vertex3.getY()) + 
                         vertex2.getX() * (vertex3.getY() - vertex1.getY()) +
                         vertex3.getX() * (vertex1.getY() - vertex2.getY())
                         )/ 2);
    }

    public double getPerimeter (){
		double xy = this.vertex1.getDistance(vertex2);
		double yz = this.vertex2.getDistance(vertex3);
		double xz = this.vertex3.getDistance(vertex1);
	
		return xy + yz + xz;
	}
}