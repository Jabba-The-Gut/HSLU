package ch.hslu.oop.sw10.Console;

/**
 * Enum, welches einen maximalen oder minimalen Temperaturwert kennzeichnet
 * 
 * @author Dave
 *
 */
public enum MaxOrMinEnum {
	MAX("Maximum"), MIN("Minimum");
	
	private String pretty;
	
	private MaxOrMinEnum(String pretty) {
		this.pretty = pretty;
	}
	
	public String returnPrettyFormat() {
		return this.pretty;
	}

}
