package hu.bme.team5;

import java.util.Random;

public class Unstable extends Iceberg {

    public Unstable() {
        super();
        Random rand = new Random();
        capacity = rand.nextInt(Map.characters.size());
        
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
        Hole h = new Hole();
        h.setMap(this.map);
        h.setNeighbors(neighbors);
        Map.fields.add(Map.fields.indexOf(this), h);
        for(Character c : characters){
            h.stepOn(c);
        }
        System.out.println("<getDestroyed");
    }

    public void setCapacity(int c){
        capacity=c;
    }
}
