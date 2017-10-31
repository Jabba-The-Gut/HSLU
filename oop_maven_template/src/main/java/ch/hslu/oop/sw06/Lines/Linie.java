package ch.hslu.oop.sw06.Lines;

/**
 * Klasse, welche eine Linie mit 2 Endpunkten darstellt
 *
 * @author JabbaTheGut
 * @version 2017.10.10
 */
public class Linie
{
    // Endpunkte als Koordinaten (x/y)
    private Point start;
    private Point end;
    private Canvas canvas;

    /**
     * Konstruktor für Linie mit Endpunkten.
     */
    public Linie(int x1, int y1, int x2, int y2)
    {
        start = new Point(x1, y1);
        end = new Point (x2, y2);
        canvas = new Canvas("DrawLines", 600,600);
    }

    private Point getStart(){
        return start;
    }

    private Point getEnd(){
        return end;
    }

    /**
     * Methode changeStartAndEnd.
     *
     * @param x1 neue X-Koordinate Anfangspunkt
     * @param y1 neue Y-Koordinate Anfangspunkt
     * @param x2 neue X-Koordinate Endpunkt
     * @param y2 neue Y-Koordinate Endpunkt
     */
    public void changeStartAndEnd(int x1, int y1, int x2, int y2){
        start.setX(x1);
        start.setY(y1);
        end.setX(x2);
        end.setY(y2);
    }

    /**
     * Methode, welche die momentanen Koordinaten des Anfangs- und Endpunkts der Linie ausgibt.
     */
    public void printCoordinates(){
        System.out.println("Anfang (" + getStart().getX() + "," + getStart().getY() + ") und Ende (" + getEnd().getX() + "," + getEnd().getY() + ")");
    }

    /**
     * Zeichne die Linie auf den Canvas.
     */
    public void draw()
    {
       canvas.setVisible(true);
       canvas.drawLine(getStart().getX() ,getStart().getY(), getEnd().getX(), getEnd().getY());
    }
}