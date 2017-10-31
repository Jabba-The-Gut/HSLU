/**
 * 
 */
package ch.hslu.oop.sw05.Shape;

/**
 * @author Daveeee
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Circle circle = new Circle(10, 10, 20);
        Rectangle rect = new Rectangle(50, 50, 30, 20);

        System.out.println("The circle has the X-Coor: " + circle.getX() + " and the Y-Coor: " + circle.getY()
                + " with a Area of " + circle.getArea() + ".");
        System.out.println("The rectangle has the X-Coor: " + rect.getX() + " and the Y-Coor: " + rect.getY()
                + " with a Area of " + rect.getArea() + ".");

        circle.move(30, 30);
        rect.move(100, 100);

        System.out.println("The circle has the X-Coor: " + circle.getX() + " and the Y-Coor: " + circle.getY()
                + " with a Area of " + circle.getArea() + ".");
        System.out.println("The rectangle has the X-Coor: " + rect.getX() + " and the Y-Coor: " + rect.getY()
                + " with a Area of " + rect.getArea() + ".");

    }

}
