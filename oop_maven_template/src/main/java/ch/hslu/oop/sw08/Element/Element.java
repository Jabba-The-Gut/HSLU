/**
 * 
 */
package ch.hslu.oop.sw08.Element;

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

	public final State getState() {
		if (tempCels <= meltingpoint) {
			return State.FEST;
		} else if (tempCels <= boilingpoint) {
			return State.FLÜSSIG;
		} else {
			return State.GASFÖRMIG;
		}
	}

	public final String getName() {
		return this.name;
	};

	public final int getTempCels() {
		return this.tempCels;
	}

	public abstract String toString();
}
