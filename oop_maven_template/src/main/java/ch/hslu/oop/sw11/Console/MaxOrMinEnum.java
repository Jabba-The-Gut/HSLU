package ch.hslu.oop.sw11.Console;

/**
 * Enum which stands for a Minimal or Maximal-Value of a temperatur-value
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
