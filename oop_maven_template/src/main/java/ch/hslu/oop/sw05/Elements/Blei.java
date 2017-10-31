/**
 * 
 */
package ch.hslu.oop.sw05.Elements;

/**
 * @author Daveeee
 *
 */
public class Blei extends Element {
    private static final double MELTINGPOINT = 327.43;
    private static final double BOILINGPOINT = 1744;

    public Blei(String name, int tempKelv) {
        super(name, MELTINGPOINT, BOILINGPOINT, tempKelv);
    }
}
