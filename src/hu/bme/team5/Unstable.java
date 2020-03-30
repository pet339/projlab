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

        System.out.println("characters.size() > capacity");
        if(characters.size() > capacity)
        getDestroyed();

    }

    public void getDestroyed() {
        
    }
}
