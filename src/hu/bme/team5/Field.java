package hu.bme.team5;

import java.util.ArrayList;

public abstract class Field {
    protected Map map;
    protected ArrayList<Character> characters;
    protected ArrayList<Field> neighbors;
    protected int snowSize;
    protected int capacity;

    public Field() {
        characters = new ArrayList<>();
        neighbors = new ArrayList<>();
    }

    abstract void stepOn(Character c);

    public void removeCharacter(Character c) {
        System.out.println(">removeCharacter(c)");
        characters.remove(c);
        System.out.println("<removeCharacter(c)");
    }

    public boolean checkNeighbor(Field nextField) {
        System.out.println(">checkNeighbor(nextField)");
        if(neighbors.contains(nextField)){
            System.out.println("<checkNeighbor(nextField)");
            return true;
        }
        System.out.println("<checkNeighbor(nextField)");
        return false;
    }

    public void setCharacter(Character c) {
        System.out.println(">setCharacter(c)");
        characters.add(c);
        System.out.println("<setCharacter(c)");
    }

    void setSnowSize(int s){
        System.out.println(">setSnowSize(s)");
        snowSize = s;
        System.out.println("<setSnowSize(s)");
    }

    public void setMap(Map m){
        map = m;
    }

    public void setNeighbors(ArrayList<Field> fs){
        neighbors = fs;
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
