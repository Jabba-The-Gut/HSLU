/**
 * 
 */
package ch.hslu.oop.sw11.Console;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Klass that stores different Temperatur-Objects in a Collection
 * 
 * @author Dave
 *
 */
public final class TemperaturVerlauf {
    private Collection<Temperatur> store;
    private List<TemperaturEventListener> listeners;
    private float average;
    private float currentMin;
    private float currentMax;

    public TemperaturVerlauf() {
        store = new ArrayList<>();
        listeners = new ArrayList<>();
        average = 0.0f;
    }

    /**
     * Add a Temperatur Object to the collection
     * 
     * @param temp
     *            the Temperatur-Object to add
     */
    public void add(Temperatur temp) {
        if (temp != null && (temp instanceof Temperatur)) {
            store.add(temp);

            // This is only executed if the first object is added. The first
            // object is a maximun
            // and a minimum at the same time
            if (this.getCount() == 1) {
                currentMax = temp.getKelvin();
                currentMin = temp.getKelvin();
                TemperaturEvent event1 = new TemperaturEvent(this, MaxOrMinEnum.MIN, currentMin);
                this.fireTemperaturEvent(event1);
                TemperaturEvent event2 = new TemperaturEvent(this, MaxOrMinEnum.MAX, currentMax);
                this.fireTemperaturEvent(event2);
            }
            // every time a Temperatur-Objekt is added, it it checked if the
            // newly added
            // Object is a new max odr min Object. If it is, then a
            // TemperaturEvent is fired
            if (temp.getKelvin() < currentMin) {
                currentMin = temp.getKelvin();
                TemperaturEvent event = new TemperaturEvent(this, MaxOrMinEnum.MIN, currentMin);
                this.fireTemperaturEvent(event);
            }

            if (temp.getKelvin() > currentMax) {
                currentMax = temp.getKelvin();
                TemperaturEvent event = new TemperaturEvent(this, MaxOrMinEnum.MAX, currentMax);
                this.fireTemperaturEvent(event);
            }
        }
    }

    /**
     * Removes all the Objects stored, the Temperatur-Verlauf is empty
     * afterwards
     */
    public void clear() {
        store.clear();
    }

    public int getCount() {
        return store.size();
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        if (this.getCount() == 0) {
            string.append("Keine Zusammenfassung möglich");
        } else {
            string.append("Dieses TemperaturVerlauf-Object enthält " + this.getCount() + " Objekte vom Typ Temperatur, "
                    + "\n" + "die durchschnittliche Temperatur ist "
                    + Temperatur.convertKelvinToCelsius(this.calculateAverageKelvin())
                    + " und die maximale und minimale Temperatur sind: "
                    + Temperatur.convertKelvinToCelsius(this.getMax().getKelvin()) + " / "
                    + Temperatur.convertKelvinToCelsius(this.getMin().getKelvin()));
        }
        return string.toString();
    }

    public Temperatur getMax() {
        if (this.getCount() != 0) {
            this.currentMax = Collections.max(store).getKelvin();
            return Collections.max(store);
        }
        return null;
    }

    public Temperatur getMin() {
        if (this.getCount() != 0) {
            this.currentMin = Collections.min(store).getKelvin();
            return Collections.min(store);
        }
        return null;
    }

    /**
     * Get the average of all Temperatur-objects stored
     * 
     * @return the average in float rounded to two decimal places
     */
    public float calculateAverageKelvin() {
        if (this.getCount() != 0) {
            Iterator<Temperatur> iterator = store.iterator();
            while (iterator.hasNext()) {
                average += iterator.next().getKelvin();
            }
            return TemperaturVerlauf.round((average / store.size()), 2);
        }
        return 0.0f;
    }

    /**
     * Method to round a float to two decimal places
     * 
     * @param d
     *            the float do be rounded
     * @param decimalPlace
     *            how much decimal places
     * @return the float rounded to the specified decimal places
     */
    private static final float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

    public Collection<Temperatur> getStore() {
        return this.store;
    }

    /**
     * Methode, um neue Klasse als Listener für Temperatur-Events hinzuzufügen
     * 
     * @param listener
     */
    public void addTemperaturEventListener(TemperaturEventListener listener) {
        if (listener != null) {
            listeners.add(listener);
        }
    }

    /**
     * Methode, um Klasse als Listener für Temperatur-Events zu entfernen
     * 
     * @param listener
     */
    public void removeTemperaturEventListener(TemperaturEventListener listener) {
        if (listener != null) {
            listeners.remove(listener);
        }
    }

    /**
     * Methode, welche Temperatur-Event an alle Listener weitergibt
     * 
     * @param event
     */
    public void fireTemperaturEvent(TemperaturEvent event) {
        for (TemperaturEventListener listener : listeners) {
            listener.temperaturEvent(event);
        }
    }

}
