package hu.bme.team5;

import java.io.IOException;

public class Program {

    public static void main(String[] args) {
        //Elindítja a tesztelést

        try {
            Test test = new Test();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Létrehoz egy menüt, amely vezérli a játékot
        //Menu menu = new Menu();


    }
}
