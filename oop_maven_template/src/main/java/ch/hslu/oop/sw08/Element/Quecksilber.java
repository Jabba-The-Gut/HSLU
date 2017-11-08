/**
 * 
 */
package ch.hslu.oop.sw08.Element;

/**
 * @author Daveeee
 *
 */
public final class Quecksilber extends Element {
	private static final double MELTINGPOINT = -38.83;
	private static final double BOILINGPOINT = 357;

	public Quecksilber(String name, int tempCel) {
		super(name, MELTINGPOINT, BOILINGPOINT, tempCel);
	}

	@Override
    public String toString() {
        return "Quecksilber ist bei " + this.getTempCels() + "C " + super.getState().toString() +" -- Achtung GIFTIG";
    }

}
