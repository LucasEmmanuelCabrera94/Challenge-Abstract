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

    
    public boolean alineadoconelsol(Point point){
        double totalArea = calculateArea(vertex1.getX(), vertex1.getY(), vertex2.getX(), vertex2.getY(), point.getX(), point.getY())
                         + calculateArea(vertex2.getX(), vertex2.getY(), vertex3.getX(), vertex3.getY(), point.getX(), point.getY())
                         + calculateArea(vertex3.getX(), vertex3.getY(), vertex1.getX(), vertex1.getY(), point.getX(), point.getY());

        return Double.compare(totalArea,0) == 0;
    }

     public boolean arePlanetsAligned(){
        double determinant = calculateArea(vertex1.getX(), vertex1.getY(), vertex2.getX(), vertex2.getY(), vertex3.getX(), vertex3.getY());
        return Double.compare(determinant,0) == 0;
    }

    private double calculateArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        return (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
    }

    public double getArea(){
        return Math.abs((vertex1.getX() * (vertex2.getY() - vertex3.getY()) + 
                         vertex2.getX() * (vertex3.getY() - vertex1.getY()) +
                         vertex3.getX() * (vertex1.getY() - vertex2.getY())
                         )/ 2);
    }

    public double getAreaWithOtherPoint(Point point, Point point2, Point point3){
        return Math.abs((point.getX() * (point2.getY() - point3.getY()) + 
                         point2.getX() * (point3.getY() - point.getY()) +
                         point3.getX() * (point.getY() - point2.getY())
                         )/ 2);
    }

    public double getPerimeter (){
		double xy = this.vertex1.getDistance(vertex2);
		double yz = this.vertex2.getDistance(vertex3);
		double xz = this.vertex3.getDistance(vertex1);
	
		return xy + yz + xz;
	}
}