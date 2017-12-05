/**
 * 
 */
package ch.hslu.oop.sw12.MVC;

import java.beans.PropertyChangeEvent;

/**
 * Klasse, welche als Controller dient (Nach MVC-Modell).
 * 
 * @author Daveeee
 *
 */
public class MotorController implements MotorViewEventListener {
    private Motor motor;
    private MotorView view;

    private MotorController() {
        this.motor = new Motor();
        this.view = new MotorView(motor);
        view.addMotorViewEventListener(this);
    }

    /**
     * Main-Methode, wo der Controller das MotorView-GUI erstellt, die Labels
     * entsprechend dem Motor-Objekt anpasst und das MotorView-GUI sichtbar
     * macht
     * 
     * @param args
     */
    public static void main(String[] args) {

        MotorController mainController = new MotorController();
        mainController.view.updateView();
        mainController.view.makeVisible();

    }

    // Methode welche aufgerufen wird, falls ein MotorViewEvent auftritt
    @Override
    public void MotorViewPropertyChangeEvent(PropertyChangeEvent event) {
        // Je nach dem, ob der Event "abschalten" oder "anschalten" als Property
        // hatte, wird das Motor-Objekt an
        // oder abgeschaltet
        switch (event.getPropertyName()) {
            case "anschalten":
                this.motor.switchOn();
                break;
            case "abschalten":
                this.motor.switchOff();
                break;
            case "rpm up":
                this.motor.increaseRPM();
                break;
            case "rpm down":
                this.motor.decreaseRPM();
                break;
            default:
                break;
        }
    }

}
