package hu.bme.team5;


import java.awt.*;

public class Hole extends Field {
    public Hole() {
        super();
        capacity=0;
    }

    //Lyukra lépés lekezelése
    @Override
    public void stepOn(Character c){
        //Karaktér beállítása
        setCharacter(c);
        //Hó letörlése
        setSnowSize(0);
        //Character megfullasztása
        c.drown();
    }

    //Visszaadja a fagyott itemet (Lyukban nincs fagyott item)
    @Override
    public Item getFrozenItem() {
        return null;
    }

    @Override
    public void setFrozenItem(Item i) {

    }

    //Lyukra nem lehet iglut építeni
    @Override
    public void setIgloo(boolean igloo) {

    }

    public void DrawField(Graphics g) {

        g.setColor(new Color(0, 105, 148));
        g.fillPolygon(p);
        
    }
}
