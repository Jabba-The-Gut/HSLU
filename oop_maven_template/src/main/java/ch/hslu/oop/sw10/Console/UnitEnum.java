package ch.hslu.oop.sw10.Console;

public enum UnitEnum {
	CELSIUS (-273.15f), KELVIN(0);
	
	private final float boundary;
	
	UnitEnum (float boundary){
		this.boundary = boundary;
	}
	
	public float getBoundary() {
		return boundary;
	}
}
