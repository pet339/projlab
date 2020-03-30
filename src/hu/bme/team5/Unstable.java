package hu.bme.team5;

import java.net.Socket;

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

        System.out.println("characters.size>capacity");
        if(characters.size() > capacity){
            System.out.println(">getDestroyed()");  
            getDestroyed();
            System.out.println("<getDestroyed()");
        }
    }

    public void getDestroyed() {
        ;
    }
}
