/**
 * 
 */
package ch.hslu.oop.sw10.Switchable;

/**
 * @author Daveeee
 *
 */
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
