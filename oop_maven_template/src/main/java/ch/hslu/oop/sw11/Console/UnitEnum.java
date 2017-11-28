package ch.hslu.oop.sw11.Console;

/**
 * Enum that represents a unit, either Celsius or Kelvin
 * 
 * @author Daveeee
 *
 */
public enum UnitEnum {
    CELSIUS(-273.15f), KELVIN(0);

    private final float boundary;

    UnitEnum(float boundary) {
        this.boundary = boundary;
    }

    public float getBoundary() {
        return boundary;
    }
}
