package hu.bme.team5;

import java.awt.*;
import java.util.ArrayList;

import static hu.bme.team5.MenuView.game;

public abstract class Field {
    //protected Map map; //A Fieldet tartalmazó map
    protected ArrayList<Character> characters; //Fielden lévő karakterek
    protected ArrayList<Field> neighbors; //Field szomszédjai
    protected int snowSize; //Hó nagysága 
    protected int capacity; //Mező kapacitása
    protected boolean igloo;
    protected boolean tent;
    protected boolean polarBear;
    protected static int ID = 1;
    protected int id;
    protected Map map;
    protected Polygon p;

    //Konstruktor
    public Field() {
        id = ID++;
        characters = new ArrayList<>();
        neighbors = new ArrayList<>();
        igloo = false;
        tent = false;
        snowSize = 2;
    }

    //Fieldre lépés lekezelése
    abstract void stepOn(Character c);

    //Fielden álló karakter eltávolítása
    public void removeCharacter(Character c) {
        characters.remove(c);
    }

    //Megnézzük ,hogy a paraméterként kapott field szomszédos e
    public boolean checkNeighbor(Field nextField) {
        if(neighbors.contains(nextField)){
            return true;
        }
        return false;
    }

    //Beállítunk egy ezen fielden álló karaktert
    public void setCharacter(Character c) {
        characters.add(c);
    }


    //Getter / Setterek
    void setSnowSize(int s){
        snowSize = s;
    }

    public void setMap(Map m){
        game.currentMap = m;
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

    public void gameEnded(boolean win)
    {
        game.currentMap.gameEnded(win);
    }

    abstract public Item getFrozenItem();

    abstract public void setFrozenItem(Item i);

    abstract public void setIgloo(boolean igloo);

    public int getId() {
        return id;
    }

    abstract public void DrawField(Graphics g);
    public void setPolygon(Polygon p){
        this.p = p;
    }
}
