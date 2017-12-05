/**
 * 
 */
package ch.hslu.oop.sw10.Switchable;

/**
 * Main Klasse zum Testen vom Event/Property-Patttern
 * 
 * @author Daveeee
 *
 */
public class Main {

    public static void main(String[] args) {
        Car auto = new Car("BMW");

        // dies schaltet den Motor ein, welcher den Property-Change-Event feuert
        auto.switchOn();

    }

}
