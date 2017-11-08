package ch.hslu.oop.sw08.Element;

public enum State {
	FEST("fest"), FLÜSSIG("flüssig"), GASFÖRMIG("gasförmig");
	
	private final String stateToString;
	
	private State(String string) {
		this.stateToString = string;
	}
	
	public String toString() {
		return stateToString;
	}
}
