/**
 * 
 */
package ch.hslu.oop.sw10.Switchable;

/**
 * Interface zur Sicherstellung von An- und Abschaltfunktionaliät
 * 
 * @author Daveeee
 *
 */
public interface Switchable {

    public void switchOn();

    public void switchOff();

    public boolean isSwitchedOn();

    public boolean isSwitchedOff();
}
