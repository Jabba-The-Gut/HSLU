/**
 * 
 */
package ch.hslu.oop.sw05.Elements;

/**
 * @author Daveeee
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Blei Pb = new Blei("Blei", 1800);
        Quecksilber Hg = new Quecksilber("Quecksilber", -40);
        Stickstoff N = new Stickstoff("Stickstoff", 20);
        
        System.out.println(Pb.toString());
        System.out.println(Hg.toString());
        System.out.println(N.toString());
    }

}
