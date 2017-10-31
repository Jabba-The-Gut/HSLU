/**
 * 
 */
package ch.hslu.oop.sw04.Switchable;

/**
 * Abstrakte Klasse, welche eine An- und Abschaltfunktion zur Verfuegung stellt
 * 
 * @author Daveeee
 *
 */
public abstract class AbstractSwitchable implements CountingSwitchable {

    private long switchCount;
    private boolean isSwitchedOn;

    protected AbstractSwitchable() {
        this.switchCount = 0;
        this.isSwitchedOn = false;
    }

    @Override
    public long getSwitchCount() {
        return this.switchCount;
    }

    /**
     * Methode, um Zustand auf "On" zu setzen
     */
    public final void switchOn() {
        this.switchCount++;
        this.isSwitchedOn = true;
    };

    /**
     * Methode, um Zustand auf "Off" zu setzen
     */
    public final void switchOff() {
        this.isSwitchedOn = false;
    };

    /**
     * Getter fuer den Zustand (On/Off)
     * 
     * @return true (On), false (Off)
     */
    public final boolean isSwitchedOn() {
        return this.isSwitchedOn;
    };

}
