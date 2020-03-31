package hu.bme.team5;

import java.util.ArrayList;

public abstract class Field {
    protected Map map; //A Fieldet tartalmazó map
    protected ArrayList<Character> characters; //Fielden lévő karakterek
    protected ArrayList<Field> neighbors; //Field szomszédjai
    protected int snowSize; //Hó nagysága 
    protected int capacity; //Mező kapacitása


    //Konstruktor
    public Field() {
        characters = new ArrayList<>();
        neighbors = new ArrayList<>();
    }

    //Fieldre lépés lekezelése
    abstract void stepOn(Character c);

    //Fielden álló karakter eltávolítása
    public void removeCharacter(Character c) {
        System.out.println(">removeCharacter(c)");
        characters.remove(c);
        System.out.println("<removeCharacter(c)");
    }

    //Megnézzük ,hogy a paraméterként kapott field szomszédos e
    public boolean checkNeighbor(Field nextField) {
        System.out.println(">checkNeighbor(nextField)");
        if(neighbors.contains(nextField)){
            System.out.println("<checkNeighbor(nextField)");
            return true;
        }
        System.out.println("<checkNeighbor(nextField)");
        return false;
    }

    //Beállítunk egy ezen fielden álló karaktert
    public void setCharacter(Character c) {
        System.out.println(">setCharacter(c)");
        characters.add(c);
        System.out.println("<setCharacter(c)");
    }


    //Getter / Setterek
    void setSnowSize(int s){
        System.out.println(">setSnowSize(s)");
        snowSize = s;
        System.out.println("<setSnowSize(s)");
    }

    public void setMap(Map m){
        System.out.println(">setMap(m)");
        map = m;
        System.out.println("<setMap(m)");
    }

    public void setNeighbors(ArrayList<Field> fs){
        System.out.println(">setNeighbors(fs)");
        neighbors = fs;
        System.out.println("<setNeighbors(fs)");
    }

    public void addNeighbor(Field f){
        System.out.println(">addNeighbor()");
        neighbors.add(f);
        System.out.println("<addNeighbor()");
    }

    public int getCapacity(){
        return capacity;
    }

    abstract public Item getFrozenItem();
    abstract public void setFrozenItem(Item i);
    abstract  public void setIgloo(boolean igloo);
}
