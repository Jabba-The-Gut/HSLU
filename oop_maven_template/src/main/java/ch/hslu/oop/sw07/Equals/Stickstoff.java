/**
 * 
 */
package ch.hslu.oop.sw07.Equals;

/**
 * @author Daveeee
 *
 */
public class Stickstoff extends Element {
    private static final double MELTINGPOINT = -210.1;
    private static final double BOILINGPOINT = -196;

    public Stickstoff(String name, int tempCel) {
        super(name, MELTINGPOINT, BOILINGPOINT, tempCel);
    }
}
