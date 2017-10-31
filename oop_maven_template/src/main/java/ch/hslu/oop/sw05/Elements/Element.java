/**
 * 
 */
package ch.hslu.oop.sw05.Elements;

/**
 * @author Daveeee
 *
 */
public abstract class Element {

    private int tempCels;
    private String name;
    private double meltingpoint;
    private double boilingpoint;

    protected Element(String name, double meltingpoint, double boilingpoint, int tempCel) {
        this.name = name;
        this.tempCels = tempCel;
        this.meltingpoint = meltingpoint;
        this.boilingpoint = boilingpoint;
    }

    public final String getState() {
        if (tempCels <= meltingpoint) {
            return "fest";
        } else if (tempCels <= boilingpoint) {
            return "flüssig";
        } else {
            return "gasförmig";
        }
    }

    public final String getName() {
        return this.name;
    };

    public final int getTempCels() {
        return tempCels;
    }

    public String toString() {
        return this.getName() + " Zustand:" + this.getState();
    }
}
