package hu.bme.team5;

import java.util.Random;

public class Unstable extends Iceberg {

    public Unstable() {
        super();
        Random rand = new Random();
        capacity = rand.nextInt(Map.characters.size());
        
    }

    @Override
    public void stepOn(Movable m) {
        setMovable(m);

        //Ha túl sokan állnak rajta, a jégtábla felborul
        if(movables.size() > capacity) getDestroyed();
    }

    public void getDestroyed() {
        System.out.println(">getDestroyed");
        Hole h = new Hole();
        h.setMap(this.map);
        h.setNeighbors(neighbors);
        Map.fields.add(Map.fields.indexOf(this), h);
        for(Movable m : movables){
            h.stepOn(m);
        }
        System.out.println("<getDestroyed");
    }

    public void setCapacity(int c){
        capacity=c;
    }
}
