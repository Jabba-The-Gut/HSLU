package ch.hslu.oop.sw06.JUnit;


/**
 * Demo-Klasse fuer die Aufgaben von OOP der SW03
 *
 * @author JabbaTheGut
 * @version 2017.10.03
 */
public class Demo1
{
    /**
     *Konstrutkor fuer Demo-Objekte
     */
    public Demo1()
    {
    }

    public int max(final int a, final int b){
        if(a != b){
            return a > b ? a : b;
        }
        else{
            return 0;
        }
    }

    public int min(final int a, final int b){
        return a < b ? a : b;
    }

    public int max1(final int a, final int b, final int c){
        if (a > b && a > c) {
            return a;
        }
        else if (b > c){
            return b;
        }
        else {
            return c;
        }
    }

    public void printOneToTenFor(){
        for(int i = 0; i <= 10; i++){
            System.out.println(i);
        }
    }

    public void printOneToTenWhile(){
        int i = 0;
        while(i <= 10){
            System.out.println(i);
            i++;
        }
    }

    public void printOneToTenDoWhile(){
        int i = 0;
        do {
            System.out.println(i);
            i++;
        } while (1 <= 10);

    }

    public void whileLoopWithFloat(){
        float number = 0.9f;
        int i = 0;
        while (number <= 1.0f){
            number += 0.000025f;
            i++;
            System.out.println(i);
        }

    }

    public void forLoopWithFloat(){
        float number = 0.9f;
        for(int i = 0; i == 4000;i++){
            number += 0.000025f;
        }
        System.out.println(number);

    }

    /**
     * Methode, welche mit "#" ein Rechteck in die Konsole zeichnet
     * 
     * @height int der Höhe des Rechtecks
     * @width int der Länge des Rechtecks
     */
    void printBox(final int height, final int width){
        //Das Rechteck wird Reihe für Reihe abgearbeitet,
        //bis die Letzte erreicht ist
        for(int i = 0; i < height; i++){
            //Ist i 0 oder um eins kleiner als die gewollt Höhe,
            //so bedeutet das dass es entweder die letze oder
            //die erste Reihe des Rechtecks ist und somit 
            //die width mit # gefüllt werden kann
            if( i == 0 || i == height-1){
                for(int x = 0; x < width; x++){
                    System.out.print("#");                    
                }
                System.out.println();
            }
            //Ist es nicht die erste oder letze Reihe,
            //so wird immer nur an der ersten und an der letzen Stelle
            //ein # eingesetzt, sonst werden Leerschläge eingesetzt.
            else{
                for(int y = 0; y < width; y++){
                    System.out.print(y == 0 || y == width-1 ? "#" : " ");
                }
                System.out.println();
            }
        }
    }
}
 