/**
 * 
 */
package ch.hslu.oop.sw06.Shape;

/**
 * Klasse, welche die Form Kreis darstellt und von Shape erbt.
 * 
 * @author Daveeee
 *
 */
public final class Circle extends Shape {
	private double diameter;

	public Circle(int x, int y, double diameter) {
		super(x, y);
		this.diameter = diameter;
	}

	public final void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public final double getDiameter() {
		return diameter;
	}

	@Override
	public double getPerimeter() {
		return diameter * Math.PI;
	}

	@Override
	public double getArea() {
		return (Math.PI * Math.pow(diameter, 2));
	}

}
