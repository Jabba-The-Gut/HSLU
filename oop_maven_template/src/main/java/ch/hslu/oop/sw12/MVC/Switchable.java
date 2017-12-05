/**
 * 
 */
package ch.hslu.oop.sw12.MVC;

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
