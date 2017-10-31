/**
 * 
 */
package ch.hslu.oop.sw06.Calculator;

/**
 * @author Daveeee
 *
 */
public class Calculator implements Computable {

    public Calculator(){
    }
    /**
     * Methode zur Addition zweier Zahlen als Integer
     */
    @Override
    public int additionInt(int int1, int int2) {
            return int1 + int2;
    }
    
}
