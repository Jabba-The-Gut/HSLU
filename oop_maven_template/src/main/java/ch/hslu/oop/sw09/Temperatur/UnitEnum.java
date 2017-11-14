package ch.hslu.oop.sw09.Temperatur;

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
