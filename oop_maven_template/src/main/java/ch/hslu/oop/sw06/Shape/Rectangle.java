/**
 * 
 */
package ch.hslu.oop.sw06.Shape;

/**
 * Klasse, welche die Form Recheck darstellt und von Shape erbt.
 * 
 * @author Daveeee
 *
 */
public final class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public final void changeDimensions(int newWidth, int newHeight) {
        this.height = newHeight;
        this.width = newWidth;
    }

    public final int getWidth() {
        return width;
    }

    public final int getHeight() {
        return height;
    }

    @Override
    public double getPerimeter() {
        return (2 * width) + (2 * height);
    }

    @Override
    public double getArea() {
        return (width * height);
    }

    @Override
    public double getDiameter() {
        return width;
    }

}
