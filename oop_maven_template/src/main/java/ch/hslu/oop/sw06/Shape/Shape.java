/**
 * 
 */
package ch.hslu.oop.sw06.Shape;

/**
 * Klasse, welche geometrische Formen mit X- und Y-Koordinaten definiert.
 * 
 * @author Daveeee
 *
 */
public abstract class Shape {
    private int x;
    private int y;

    protected  Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public final void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }
    
    /**
     * Je nach Form untersch. Berechnung
     * @return nichts
     */
    public abstract double getDiameter();

    /**
     * Je nach Form untersch. Berechnung
     * 
     * @return nichts
     */
    public abstract double getPerimeter();

    /**
     * Je nach Form untersch. Berechnung
     * 
     * @return nichts
     */
    public abstract double getArea();

}
