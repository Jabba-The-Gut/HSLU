package ch.hslu.oop.sw11.Console;

/**
 * Alle Klassen, die dieses Interface implementieren, können Events vom Typ
 * TemperaturEvent empfangen
 * 
 * @author Dave
 *
 */
public interface TemperaturEventListener {
    public void temperaturEvent(TemperaturEvent event);
}
