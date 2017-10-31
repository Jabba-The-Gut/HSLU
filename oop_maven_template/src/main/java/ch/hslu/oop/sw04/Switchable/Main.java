/**
 * 
 */
package ch.hslu.oop.sw04.Switchable;

/**
 * @author Daveeee
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Car bmw = new Car();
        
        System.out.println(bmw.toString());

        for (int i = 0; i < 10; i++) {
            bmw.powerOn();
            if (bmw.isSwitchedOn()) {
                System.out.println("BMW [Status]: Wrmm... Wrm.....");
            }
            bmw.powerOff();

        }

        System.out.println(bmw.toString());

        System.out.println("BMW [Status]: Anzahl Zustandsveranderungen: " + bmw.getSwitchCount());

    }

}
