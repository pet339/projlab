package hu.bme.team5;

import java.util.Random;

import static hu.bme.team5.Menu.game;

public class Unstable extends Iceberg {

    public Unstable() {
        super();
        Random rand = new Random();
        capacity = rand.nextInt(game.currentMap.characters.size());
        
    }

    @Override
    public void stepOn(Character c) {
        setCharacter(c);

        //Ha túl sokan állnak rajta, a jégtábla felborul
        if(characters.size() > capacity) getDestroyed();
    }

    public void getDestroyed() {
        Hole h = new Hole();
        h.setMap(game.currentMap);
        h.setNeighbors(neighbors);
        game.currentMap.fields.add(game.currentMap.fields.indexOf(this), h);
        for(Character c : characters){
            h.stepOn(c);
        }
    }

    public void setCapacity(int c){
        capacity=c;
    }
}
