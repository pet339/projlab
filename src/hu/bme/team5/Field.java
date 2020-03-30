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
        System.out.println(">Field.removeCharacter(c)");
        characters.remove(c);
        System.out.println("<Field.removeCharacter(c)");
    }

    public boolean checkNeighbor(Field nextField) {
        System.out.println(">Field.checkNeighbor(nextField)");
        if(neighbors.contains(nextField)){
            System.out.println("<Field.checkNeighbor(nextField)");
            return true;
        }
        System.out.println("<Field.checkNeighbor(nextField)");
        return false;
    }

    public void setCharacter(Character c) {
        System.out.println(">Field.setCharacter(c)");
        characters.add(c);
        System.out.println("<Field.setCharacter(c)");
    }

    void setSnowSize(int s){
        System.out.println(">Field.setSnowSize(s)");
        snowSize = s;
        System.out.println("<Field.setSnowSize(s)");
    }

    public void setMap(Map m){
        map = m;
    }

    public void setNeighbors(ArrayList<Field> fs){
        neighbors = fs;
    }

    public void addNeighbor(Field f){
        System.out.println(">Field.addNeighbor()");
        neighbors.add(f);
        System.out.println("<Field.addNeighbor()");
    }

    public int getCapacity(){
        return capacity;
    }

    abstract public Item getFrozenItem();
    abstract public void setFrozenItem(Item i);
}
