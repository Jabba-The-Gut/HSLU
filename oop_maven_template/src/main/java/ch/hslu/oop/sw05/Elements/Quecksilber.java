/**
 * 
 */
package ch.hslu.oop.sw05.Elements;

/**
 * @author Daveeee
 *
 */
public class Quecksilber extends Element {
    private static final double MELTINGPOINT = -38.83;
    private static final double BOILINGPOINT = 357;

    public Quecksilber(String name, int tempKelv) {
        super(name, MELTINGPOINT, BOILINGPOINT, tempKelv);
    }

    @Override
    public String toString() {
        return super.toString() + " -- Achtung GIFTIG";
    }

}
