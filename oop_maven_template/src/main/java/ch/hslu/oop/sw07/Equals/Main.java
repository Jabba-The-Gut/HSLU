/**
 * 
 */
package ch.hslu.oop.sw07.Equals;

/**
 * @author Daveeee
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
      Linie line1 = new Linie(10, 10, 100, 100);
      
      line1.draw();
      
      line1.changeStartAndEnd(20, 300, 50, 300);
      
      line1.draw();
      
      

    }

}
