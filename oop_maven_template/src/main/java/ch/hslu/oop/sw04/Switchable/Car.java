package ch.hslu.oop.sw04.Switchable;

/**
 * Klasse welche ein abstrahiertes Fahrzeug darstellt
 *
 * @author JabbaTheGut
 * @version 2017.10.10
 */
public class Car extends AbstractSwitchable {

    // Motor des Autos
    private Motor engine;
    // Licht des Autos
    private Light light;

    /**
     * Initialisierung eines neuen Car-Objekts
     */
    public Car() {
        super();
        engine = new Motor();
        light = new Light();
    }

    public void powerOn() {
        if (!this.isSwitchedOn()) {
            engine.switchOn();
            light.switchOn();
            this.switchOn();
        }
    }

    public void powerOff() {
        if (this.isSwitchedOn()) {
            engine.switchOff();
            light.switchOff();
            this.switchOff();
        }
    }

    @Override
    public String toString() {
        return "Zustand Auto: " + (this.isSwitchedOn()? "laufen" : "ausgeschaltet");
    }
    
    
}