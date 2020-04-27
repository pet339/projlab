package hu.bme.team5;

public class Hole extends Field {
    public Hole() {
        super();
        capacity=0;
    }

    //Lyukra lépés lekezelése
    @Override
    public void stepOn(Movable m) {
        //Karaktér beállítása
        setMovable(m);
        //Hó letörlése
        setSnowSize(0);
        //Character megfullasztása
        movables.get(movables.size()-1).drown();
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
}
