/**
 * 
 */
package ch.hslu.oop.sw12.MVC;

import java.awt.Event;
import java.beans.PropertyChangeEvent;

/**
 * Interface, das alle Klassen implementieren müssen, welche
 * PropertyChangeEvents empfangen wollen
 * 
 * @author Daveeee
 *
 */
public interface PropertyChangeListener {

    public void  propertyChangeEvent(PropertyChangeEvent PropertyChangeEvent);
}
