/**
 * 
 */
package ch.hslu.oop.sw05.Elements;

/**
 * @author Daveeee
 *
 */
public class Stickstoff extends Element {
    private static final double MELTINGPOINT = -210.1;
    private static final double BOILINGPOINT = -196;

    public Stickstoff(String name, int tempKelv) {
        super(name, MELTINGPOINT, BOILINGPOINT, tempKelv);
    }
}
