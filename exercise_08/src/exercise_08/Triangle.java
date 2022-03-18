package exercise_08;

abstract class GeometricObject{
	private String color="white";
	private boolean isFilled;
	
	protected GeometricObject() {}

	protected GeometricObject(String color, boolean filled) {
		this.color = color;
		this.isFilled = filled;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return isFilled;
	}

	public void setFilled(boolean filled) {
		this.isFilled = filled;
	}

	@Override
	public String toString() {
		return "GeometricObject [color=" + color + ", filled=" + isFilled + "]";
	}
	
	public abstract double getArea();
	
	public abstract double getPerimeter();
	
}


public class Triangle extends GeometricObject{
	
	private double side1=1.0,side2=1.0,side3=1.0;
	
	public Triangle() {}
	
	public Triangle(double side1,double side2,double side3) throws IllegalTriangleException{
		if((side1+side2)>side3&(side1+side3)>side2&(side2+side3)>side1) {		
			this.side1 = side1;
			this.side2 = side2;
			this.side3 = side3;
		}
		else {
			throw new IllegalTriangleException(side1,side2,side3);
		}

	}

	public double getSide1() {
		return side1;
	}
	public double getSide2() {
		return side2;
	}
	public double getSide3() {
		return side3;
	}
	
	public double getArea() {
		double s=(side1+side2+side3)/2;
		return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
	}
	
	public double getPerimeter() {
		return (side1+side2+side3);
	}

	@Override
	public String toString() {
		return "Triangle:side1 = "+side1+" side2 = "+side2+" side3 ="+side3;
	}
	
	
	

}
