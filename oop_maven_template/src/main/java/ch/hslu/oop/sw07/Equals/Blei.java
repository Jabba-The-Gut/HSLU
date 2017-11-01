/**
 * 
 */
package ch.hslu.oop.sw07.Equals;

/**
 * @author Daveeee
 *
 */
public class Blei extends Element {
    private static final double MELTINGPOINT = 327.43;
    private static final double BOILINGPOINT = 1744;

    public Blei(String name, int tempCel) {
        super(name, MELTINGPOINT, BOILINGPOINT, tempCel);
    }
}
