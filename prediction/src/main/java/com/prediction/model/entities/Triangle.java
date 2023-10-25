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
    private double tolerance = 1e-15;

    /**
     * If the three cross products have the same sign (all positive or all negative),
     * then the sun is inside the triangle. If the signs are different, the sun is outside the triangle.
     * @param point is a point that has a precise location.
     * @return if the point is inside the triangle.
     */
    public boolean pointContainedInTriangle(Point point){
        double crossProduct1 = (vertex1.getX() - point.getX()) * (vertex1.getY() - point.getY());
        double crossProduct2 = (vertex2.getX() - point.getX()) * (vertex2.getY() - point.getY());
        double crossProduct3 = (vertex3.getX() - point.getX()) * (vertex3.getY() - point.getY());
       
        return ((crossProduct1 > 0 && crossProduct2 > 0 && crossProduct3 > 0) || (crossProduct1 < 0 && crossProduct2 < 0 && crossProduct3 < 0));
    }

    /**
     * The same formula for the area of the triangle is applied using the coordinates of the sun and two planets.
     * If the area of the triangle formed by the sun and the two planets is zero, then the planets are aligned with the sun.
     * @param point is a point that has a precise location.
     * @return if the planets are aligned with the sun.
     */
    public boolean alignedWithTheSun(Point point){
        double area = calculateArea(vertex1.getX(), vertex1.getY(), vertex2.getX(), vertex2.getY(), point.getX(), point.getY());
        return (Math.abs(area) == tolerance);
    }

    /**
     * If the area of the triangle formed by the three planets is zero, it means that the planets are aligned.
     * @return if the planets are aligned.
     */
     public boolean arePlanetsAligned(){
        double area = calculateArea(vertex1.getX(), vertex1.getY(), vertex2.getX(), vertex2.getY(), vertex3.getX(), vertex3.getY());
        return (Math.abs(area) == tolerance);
    }

    /**
     * The calculation is performed to obtain the area of the points of a triangle.
     * @return the result of the area.
     */
    private double calculateArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        return  0.5 * Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)));
    }

    /**
     * The calculation is performed to obtain the perimeter of a triangle.
     * @return the result of the perimeter.
     */
    public double getPerimeter (){
		double xy = this.vertex1.getDistance(vertex2);
		double yz = this.vertex2.getDistance(vertex3);
		double xz = this.vertex3.getDistance(vertex1);
	
		return xy + yz + xz;
	}
}