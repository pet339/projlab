package hu.bme.team5;

import java.util.Random;

import static hu.bme.team5.MenuView.game;
import java.awt.*;

public class Unstable extends Iceberg {

    public Unstable() {
        super();
        capacity = r.nextInt(3) + 1;
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
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(4, 167, 52));
        
        g2.fillPolygon(p);
        if(snowSize!=0){
            g2.setColor(new Color(138,195,209));
            g2.fillPolygon(p);
        }
        
    }

    public void getExplored(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(154, 102, 66));
        
        g2.fillPolygon(p);
        if(snowSize!=0){
            g2.setColor(new Color(138,195,209));
            g2.setStroke(new BasicStroke(10));
            g2.drawPolygon(p);
        }
    }
}
