package hu.bme.team5;

import java.net.Socket;
import java.util.Scanner;

public class Unstable extends Iceberg {
    private int capacity;

    public Unstable() {
        super();
    }

    @Override
    public void stepOn(Character c) {
        System.out.println(">setCharacter(c)");
        setCharacter(c);
        System.out.println("<setCharacter(c)");


        System.out.println("-Kisebb a mezö kapacitasa, mint ahany karakter all rajta?(i/n)");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.equals("i")){
            System.out.println(">getDestroyed()");
            getDestroyed();

            System.out.println("<getDestroyed()");
        }
        sc.close();
    }

    public void getDestroyed() {
        ;
    }
}
