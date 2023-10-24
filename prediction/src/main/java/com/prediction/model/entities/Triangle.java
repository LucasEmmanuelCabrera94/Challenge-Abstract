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

    //Si los tres productos cruzados tienen el mismo signo (todos positivos o todos negativos),
    //entonces el sol está dentro del triángulo. Si los signos son diferentes, el sol está fuera del triángulo.
    public boolean pointContainedInTriangle(Point point){
        double crossProduct1 = (vertex1.getX() - point.getX()) * (vertex1.getY() - point.getY());
        double crossProduct2 = (vertex2.getX() - point.getX()) * (vertex2.getY() - point.getY());
        double crossProduct3 = (vertex3.getX() - point.getX()) * (vertex3.getY() - point.getY());
       
        return ((crossProduct1 > 0 && crossProduct2 > 0 && crossProduct3 > 0) || (crossProduct1 < 0 && crossProduct2 < 0 && crossProduct3 < 0));
    }

    // Se aplica la misma fórmula del área del triángulo utilizando las coordenadas del sol y dos planetas.
    // Si el área del triángulo formado por el sol y los dos planetas es cero, entonces los planetas están alineados con el sol.
    public boolean alignedWithTheSun(Point point){
        double area = calculateArea(vertex1.getX(), vertex1.getY(), vertex2.getX(), vertex2.getY(), point.getX(), point.getY());
        return (Math.abs(area) == tolerance);
    }

    //Si el área del triángulo formado por lo
    // s tres planetas es cero, significa que los planetas están alineados
     public boolean arePlanetsAligned(){
        double area = calculateArea(vertex1.getX(), vertex1.getY(), vertex2.getX(), vertex2.getY(), vertex3.getX(), vertex3.getY());
        return (Math.abs(area) == tolerance);
    }

    private double calculateArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        return  0.5 * Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)));
    }

    public double getPerimeter (){
		double xy = this.vertex1.getDistance(vertex2);
		double yz = this.vertex2.getDistance(vertex3);
		double xz = this.vertex3.getDistance(vertex1);
	
		return xy + yz + xz;
	}
}