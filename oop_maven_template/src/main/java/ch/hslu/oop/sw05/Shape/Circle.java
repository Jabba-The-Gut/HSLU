/**
 * 
 */
package ch.hslu.oop.sw05.Shape;

/**
 * Klasse, welche die Form Kreis darstellt und von Shape erbt.
 * 
 * @author Daveeee
 *
 */
public class Circle extends Shape {
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
    public final double getPerimeter() {
        return diameter * Math.PI;
    }

    @Override
    public final double getArea() {
        return (Math.PI * Math.pow(diameter, 2)) / 2;
    }

}
