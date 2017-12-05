/**
 * 
 */
package ch.hslu.oop.sw12.MVC;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasse, welche einen abstrahierten Motor darstellt
 * 
 * @author Daveeee
 *
 */
public class Motor implements Switchable {
    private int rpm;
    private MotorStateEnum state;

    // Liste, welche alle Klassen enthält, die auf Events von Motor hören
    private List<PropertyChangeListener> listeners;

    // Enum fuer die Motor-Zustaende
    public enum MotorStateEnum {
        ON("angeschaltet"), OFF("ausgeschaltet"), FAILURE("fehler");

        private String state;

        private MotorStateEnum(String state) {
            this.state = state;
        }

        @Override
        public String toString() {
            return this.state;
        }

    }

    public Motor() {
        this.rpm = 0;
        state = MotorStateEnum.OFF;
        listeners = new ArrayList<>();
    }

    public int getRPM() {
        return this.rpm;
    }
    
    public void increaseRPM() {
        this.rpm = rpm + 10;
    }
    
    public void decreaseRPM() {
        if(rpm != 10 && rpm > 0) {
            this.rpm = rpm - 10;
        } else {
            this.switchOff();
        }
    }

    @Override
    public void switchOn() {
        if (this.isSwitchedOff()) {
            this.rpm = 10;
            this.state = MotorStateEnum.ON;

            final PropertyChangeEvent event = new PropertyChangeEvent(this, "Zustand Motor:",
                    MotorStateEnum.OFF.toString(), state.toString());
            this.firePropertyChangeEvent(event);
        }
    }

    @Override
    public void switchOff() {
        if (this.isSwitchedOn()) {
            this.rpm = 0;
            this.state = MotorStateEnum.OFF;

            final PropertyChangeEvent event = new PropertyChangeEvent(this, "Zustand Motor:",
                    MotorStateEnum.ON.toString(), state.toString());
            this.firePropertyChangeEvent(event);
        }
    }

    @Override
    public boolean isSwitchedOn() {
        return this.state == MotorStateEnum.ON ? true : false;
    }

    @Override
    public boolean isSwitchedOff() {
        return this.state == MotorStateEnum.OFF ? true : false;
    }

    /**
     * Methode, welche Klassen als Listener für Motor-Events hinzufügt
     * 
     * @param listener
     *            Klasse, welche Events empfangen will
     */
    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        if (listener != null) {
            this.listeners.add(listener);
        }
    }

    /**
     * Methode, welche Klassen als Listener für Motoren-Events entfernt
     * 
     * @param listener
     *            Klasse, welche als Listener entfernt werden soll
     */
    public void removePropertyChangeListener(final PropertyChangeListener listener) {
        if (listener != null) {
            this.listeners.remove(listener);
        }
    }

    /**
     * Methode, welche alle als Listener registrierte Klassen über einen Event
     * informiert
     * 
     * @param event
     *            der aufgetretene Event
     */
    private void firePropertyChangeEvent(final PropertyChangeEvent event) {
        for (PropertyChangeListener listener : this.listeners) {
            listener.propertyChangeEvent(event);
        }
    }
}
