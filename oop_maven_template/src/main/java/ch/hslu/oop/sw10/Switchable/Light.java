/**
 * 
 */
package ch.hslu.oop.sw10.Switchable;

/**
 * Klasse, welche ein abstrahiertes Licht darstellt
 * 
 * @author Daveeee
 *
 */
public class Light implements Switchable {
    private int lumen;

    public Light() {
        this.lumen = 0;
    }

    @Override
    public void switchOn() {
        this.lumen = 10;
    }

    @Override
    public void switchOff() {
        this.lumen = 0;
    }

    @Override
    public boolean isSwitchedOn() {
        return this.lumen > 0 ? true : false;
    }

    @Override
    public boolean isSwitchedOff() {
        return this.lumen == 0 ? true : false;
    }
}
