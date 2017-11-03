/**
 * 
 */
package ch.hslu.oop.sw07.Equals;

/**
 * @author Daveeee
 *
 */
public class Quecksilber extends Element {
    private static final double MELTINGPOINT = -38.83;
    private static final double BOILINGPOINT = 357;

    public Quecksilber(String name, int tempCel) {
        super(name, MELTINGPOINT, BOILINGPOINT, tempCel);
    }

    @Override
    public String toString() {
        return super.toString() + " -- Achtung GIFTIG";
    }

}
