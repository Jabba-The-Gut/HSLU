/**
 * 
 */
package ch.hslu.oop.sw10.Switchable;

import java.beans.PropertyChangeEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Klasse, um einen abstrahierten Motor darzustellen
 * 
 * @author Daveeee
 *
 */
public class Car implements Switchable, PropertyChangeListener {
    private String model;
    private boolean running;
    private Light lightFrontLeft;
    private Light lightFrontRight;
    private Motor motor;
    private static final Logger LOG = LogManager.getLogger(Car.class);

    public Car(String model) {
        this.model = model;
        lightFrontLeft = new Light();
        lightFrontRight = new Light();
        motor = new Motor();
        
        //Hinzufügen von Auto als Listener vom Motor
        motor.addPropertyChangeListener(this);
    }

    public String getModel() {
        return this.model;
    }

    @Override
    public void switchOn() {
        if(this.isSwitchedOff()) {
            this.running = true;
            lightFrontLeft.switchOn();
            lightFrontRight.switchOn();
            motor.switchOn();
        }
    }

    @Override
    public void switchOff() {
        if(this.isSwitchedOn()) {
            this.running = false;
            lightFrontLeft.switchOff();
            lightFrontRight.switchOff();
            motor.switchOff();
        }
    }

    @Override
    public boolean isSwitchedOn() {
        return this.running == true ? true : false;
    }

    @Override
    public boolean isSwitchedOff() {
        return this.running == false ? true : false;
    }

    @Override
    public void propertyChangeEvent(PropertyChangeEvent PropertyChangeEvent) {
        LOG.info("Neuer Wert: " + PropertyChangeEvent.getNewValue()
        + " Alter Wert: " + PropertyChangeEvent.getOldValue());
    }
}
