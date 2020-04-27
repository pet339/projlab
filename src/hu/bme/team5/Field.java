package hu.bme.team5;

import java.util.ArrayList;

public abstract class Field {
    protected Map map; //A Fieldet tartalmazó map
    protected ArrayList<Movable> movables; //Fielden lévő karakterek
    protected ArrayList<Field> neighbors; //Field szomszédjai
    protected int snowSize; //Hó nagysága 
    protected int capacity; //Mező kapacitása
    protected boolean igloo;
    protected boolean tent;
    protected boolean polarBear;
    protected static int ID = 1;
    protected int id;

    //Konstruktor
    public Field() {
        id = ID++;
        movables = new ArrayList<>();
        neighbors = new ArrayList<>();
    }

    //Fieldre lépés lekezelése
    abstract void stepOn(Movable m);

    //Fielden álló karakter eltávolítása
    public void removeMovable(Movable m) {
        movables.remove(m);
    }

    //Megnézzük ,hogy a paraméterként kapott field szomszédos e
    public boolean checkNeighbor(Field nextField) {
        if(neighbors.contains(nextField)){
            return true;
        }
        return false;
    }

    //Beállítunk egy ezen fielden álló karaktert
    public void setMovable(Movable m) {
        movables.add(m);
    }


    //Getter / Setterek
    void setSnowSize(int s){
        snowSize = s;
    }

    public void setMap(Map m){
        map = m;
    }

    public void setNeighbors(ArrayList<Field> fs){
        neighbors = fs;
    }

    public void addNeighbor(Field f) {
        neighbors.add(f);
    }

    public ArrayList<Field> getNeighbors() {
        return neighbors;
    }

    public int getCapacity() {
        return capacity;
    }

    public void GameEnded(boolean win)
    {
        map.GameEnded(win);
    }

    abstract public Item getFrozenItem();

    abstract public void setFrozenItem(Item i);

    abstract public void setIgloo(boolean igloo);

    public int getId() {
        return id;
    }
}
