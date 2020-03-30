package hu.bme.team5;

import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Unstable extends Iceberg {
    private int capacity;

    public Unstable() {
        super();
        Random rand = new Random();
        capacity = rand.nextInt(map.characters.size());
        
    }

    @Override
    public void stepOn(Character c) {
        System.out.println(">stepOn(c)");
        setCharacter(c);
        

        System.out.println("characters.size() > capacity");
        if(characters.size() > capacity)
        getDestroyed();
        System.out.println("<stepOn(c)");

    }

    public void getDestroyed() {
        System.out.println(">getDestroyed");
        System.out.println("<getDestroyed");
    }
}
