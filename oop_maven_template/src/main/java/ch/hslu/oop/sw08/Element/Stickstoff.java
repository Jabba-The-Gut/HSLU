/**
 * 
 */
package ch.hslu.oop.sw08.Element;

/**
 * @author Daveeee
 *
 */
public final class Stickstoff extends Element {
    private static final double MELTINGPOINT = -210.1;
    private static final double BOILINGPOINT = -196;

    public Stickstoff(String name, int tempCel) {
        super(name, MELTINGPOINT, BOILINGPOINT, tempCel);
    }

	@Override
	public String toString() {
		return "Stickstoff ist bei " + this.getTempCels() + "C " + super.getState().toString();
	}
    
    
}
