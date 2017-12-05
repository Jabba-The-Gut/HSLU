/**
 * 
 */
package ch.hslu.oop.sw12.MVC;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ch.hslu.oop.sw12.MVC.Motor.MotorStateEnum;

/**
 * Klasse, welche ein GUI darstellt und somit als View dient (nach MVC-Modell).
 * Das GUI dient zur Bedienung des Model (Motor)
 * 
 * @author Daveeee
 *
 */
public class MotorView extends JFrame implements ActionListener {
    // GUI Elements
    private JLabel lblRPM;
    private JLabel rpm;
    private JLabel lblStatus;
    private JLabel status;
    private JButton btnOn;
    private JButton btnOff;
    private JButton btnRMPUp;
    private JButton btnRPMDown;

    // Liste fuer alle MotorViewEventListener
    private List<MotorViewEventListener> listeners;

    // Motor-Objekt fuer das View
    private Motor motor;

    public MotorView(Motor motor) {
        this.listeners = new ArrayList<>();
        this.motor = motor;

        this.rpm = new JLabel("...");
        this.lblRPM = new JLabel("RPM:");
        this.status = new JLabel("...");
        this.lblStatus = new JLabel("Status:");
        this.btnOff = new JButton("Turn Off");
        this.btnOn = new JButton("Turn On");
        this.btnRMPUp = new JButton("Increase rpm");
        this.btnRPMDown = new JButton("Decrease rpm");

        // Set Layout of Frame
        this.setLayout(new BorderLayout());

        // Add FlowLayout to SOUTH of Frame
        Container containerButtonsOnOff = new Container();
        containerButtonsOnOff.setLayout(new FlowLayout());
        containerButtonsOnOff.add(btnOn);
        containerButtonsOnOff.add(btnOff);
        Container containerButtonsRPM = new Container();
        containerButtonsRPM.setLayout(new GridLayout(2, 1));
        containerButtonsRPM.add(btnRMPUp);
        containerButtonsRPM.add(btnRPMDown);
        containerButtonsOnOff.add(containerButtonsRPM);
        this.add(containerButtonsOnOff, BorderLayout.SOUTH);

        // Create two FlowLayouts for Labels
        Container containerLabelState = new Container();
        containerLabelState.setLayout(new FlowLayout());
        containerLabelState.add(lblStatus);
        containerLabelState.add(status);
        Container containerLabelRPM = new Container();
        containerLabelRPM.setLayout(new FlowLayout());
        containerLabelRPM.add(lblRPM);
        containerLabelRPM.add(rpm);

        // Add FlowLayout to wrap the two FlowLayouts of the labels
        Container containerLabel = new Container();
        containerLabel.setLayout(new GridLayout(2, 1));
        containerLabel.add(containerLabelState);
        containerLabel.add(containerLabelRPM);

        // Add wrapping FlowLayout to Frame
        this.add(containerLabel, BorderLayout.CENTER);

        // Add Action-Listeners to Buttons
        this.btnOff.addActionListener(this);
        this.btnOn.addActionListener(this);
        this.btnRMPUp.addActionListener(this);
        this.btnRPMDown.addActionListener(this);

        // Set Visibility of Buttons at the Beginning
        this.btnOff.setVisible(true);
        this.btnOn.setVisible(true);
        this.btnRMPUp.setVisible(false);
        this.btnRPMDown.setVisible(false);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
    }

    /**
     * Methode, um JFrame sichtbar zu machen
     */
    public void makeVisible() {
        this.setVisible(true);
    }

    /*
     * Methode, um Status von Motor abzufragen und Labels anzupassen
     */
    public void updateView() {
        this.status.setText(this.motor.isSwitchedOn() ? MotorStateEnum.ON.toString() : MotorStateEnum.OFF.toString());
        this.rpm.setText(String.valueOf(this.motor.getRPM()));

        // If Motor is not switched on, remove buttons for rpm
        if (this.motor.isSwitchedOff()) {
            this.btnRMPUp.setVisible(false);
            this.btnRPMDown.setVisible(false);
        } else {
            this.btnRMPUp.setVisible(true);
            this.btnRPMDown.setVisible(true);
        }

        // If Motor is not switched on, set Availability of buttons for
        // On/Off
        if (this.motor.isSwitchedOff()) {
            this.btnOn.setEnabled(true);
            this.btnOff.setEnabled(false);
        } else {
            this.btnOn.setEnabled(false);
            this.btnOff.setEnabled(true);
        }

        // If rpm is higher than 100, show error message and exit
        if (this.motor.getRPM() > 100) {
            JOptionPane.showMessageDialog(this, "Motor explodiert, zu hohe Drehzahl");
            System.exit(ERROR);
        }
    }

    /**
     * Methode, welche aufgerufen wird, falls ein Action-Event auftritt, also
     * wenn ein Button geklickt wird
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Je nach dem, welcher Button gedrueckt wurde, wird ein neuer
        // MotorViewEvent(PropertyChangeEvent) an alle Listener (hier
        // MotorController) gesendet
        if (e.getSource() == this.btnOff) {
            final PropertyChangeEvent event = new PropertyChangeEvent(this, "abschalten", false, true);
            this.fireMotorViewEvent(event);

            // Labels updaten
            this.updateView();

        } else if (e.getSource() == this.btnOn) {
            final PropertyChangeEvent event = new PropertyChangeEvent(this, "anschalten", false, true);
            this.fireMotorViewEvent(event);

            // Labels upaten
            this.updateView();

        } else if (e.getSource() == this.btnRMPUp) {
            final PropertyChangeEvent event = new PropertyChangeEvent(this, "rpm up", false, true);
            this.fireMotorViewEvent(event);

            // Labels updaten
            this.updateView();

        } else if (e.getSource() == this.btnRPMDown) {
            final PropertyChangeEvent event = new PropertyChangeEvent(this, "rpm down", false, true);
            this.fireMotorViewEvent(event);

            // Labels updaten
            this.updateView();

        }
    }

    /**
     * Methode, welche Klassen als Listener für MotorView-Events hinzufügt
     * 
     * @param listener
     *            Klasse, welche Events empfangen will
     */
    public void addMotorViewEventListener(final MotorViewEventListener listener) {
        if (listener != null) {
            this.listeners.add(listener);
        }
    }

    /**
     * Methode, welche Klassen als Listener für MotorView-Events entfernt
     * 
     * @param listener
     *            Klasse, welche als Listener entfernt werden soll
     */
    public void removeMotorViewEventListener(final MotorViewEventListener listener) {
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
    private void fireMotorViewEvent(final PropertyChangeEvent event) {
        for (MotorViewEventListener listener : this.listeners) {
            listener.MotorViewPropertyChangeEvent(event);
        }
    }

}
