/**
 * 
 */
package ch.hslu.oop.sw08.Element;

/**
 * @author Daveeee
 *
 */
public final class Blei extends Element {
	private static final double MELTINGPOINT = 327.43;
	private static final double BOILINGPOINT = 1744;

	public Blei(String name, int tempCel) {
		super(name, MELTINGPOINT, BOILINGPOINT, tempCel);
	}

	@Override
	public String toString() {
		return "Blei ist bei " + this.getTempCels() + "C " + super.getState().toString();
	}
}
