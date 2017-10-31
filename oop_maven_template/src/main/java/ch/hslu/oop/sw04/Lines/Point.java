package ch.hslu.oop.sw04.Lines;

/**
 * Klasse, welche einen Kreis darstellt
 * 
 * @author JabbaTheGut
 * @version 2017.10.04
 */
public class Point {
    private int x;
    private int y;

    /**
     * Konstruktor für Objekte der Klasse Point
     */
    public Point(int x, int y) {
        this.y = y;
        this.x = x;
    }

    /**
     * Konstruktor, um ein Point-Objekt mit einem Punkt zu initialisiere
     * 
     * @param point
     *            Punkt, mit welchem das neue Objekt instanziert werden soll
     */
    public Point(Point point) {
        new Point(point.getX(), point.getY());
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Methode, welche den Quadranten des Punktes im Koordinatensystem ausgibt
     */
    public int getQuadrant() {
        if (x > 0 && y > 0) {
            return 1;
        } else if (x < 0 && y > 0) {
            return 2;
        } else if (x < 0 && y < 0) {
            return 3;
        } else if (x > 0 && y < 0) {
            return 4;
        } else {
            return 0;
        }
    }

    /**
     * Methode, um einen Punkt mit einem Vektor zu verschieben
     * 
     * @param x
     *            x-Teil des Vektors
     * @param y
     *            y-Teils des Vektors
     */
    public void moveRelative(int x, int y) {
        this.y += y;
        this.x += x;
    }

    /**
     * Methode, um einen Punkt mit einem weiteren Punkt zu verschieben
     * 
     * @param point
     *            Neuer Punkt
     */
    public void moveRelative(Point point) {
        this.x = point.getX();
        this.y = point.getY();
    }

    /**
     * Methode, um einen Punkt mit Poolarkoordinaten zu verschieben
     * 
     * @param angle
     *            Winkel
     * @param r
     *            Betrag
     */
    public void moveRelative(double angle, int r) {
        this.x = (int) (r * Math.cos(Math.toDegrees(angle)));
        this.y = (int) (r * Math.sin(Math.toDegrees(angle)));
    }
}
