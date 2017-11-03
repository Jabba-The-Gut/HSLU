/**
 * 
 */
package ch.hslu.oop.sw06.Shape;

/**
 * @author Daveeee
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Shape shape1 = new Circle(10, 10, 20);
        Shape shape2 = new Rectangle(50, 50, 30, 20);

        System.out.println("The circle has the X-Coor: " + shape1.getX() + " and the Y-Coor: " + shape1.getY()
                + " with a Area of " + shape1.getArea() + ".");
        System.out.println("The rectangle has the X-Coor: " + shape2.getX() + " and the Y-Coor: " + shape2.getY()
                + " with a Area of " + shape2.getArea() + ".");

        shape1.move(30, 30);
        shape2.move(100, 100);

        System.out.println("The circle has the X-Coor: " + shape1.getX() + " and the Y-Coor: " + shape1.getY()
                + " with a Area of " + shape1.getArea() + ".");
        System.out.println("The rectangle has the X-Coor: " + shape2.getX() + " and the Y-Coor: " + shape2.getY()
                + " with a Area of " + shape2.getArea() + ".");
        
        System.out.println(shape1.getDiameter());
    }

}
