package hu.bme.team5;

import java.util.Random;

import static hu.bme.team5.MenuView.game;
import java.awt.*;

public class Unstable extends Iceberg {

    public Unstable() {
        super();
        Random rand = new Random();
        capacity = 1;
        
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

    public void DrawField(Graphics g) {

        g.setColor(new Color(0, 105, 148));
        g.fillPolygon(p);
        
    }
}
