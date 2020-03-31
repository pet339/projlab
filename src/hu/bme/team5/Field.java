package hu.bme.team5;

import java.util.ArrayList;

public abstract class Field {
    protected Map map;
    protected ArrayList<Character> characters;
    protected ArrayList<Field> neighbors;
    protected int snowSize;

    public Field() {
        characters = new ArrayList<>();
    }

    public void stepOn(Character c) {
        ;
    }

    public void removeCharacter(Character c) {
        System.out.println(">removeCharacter(c)");
        characters.remove(c);
        System.out.println("<removeCharacter(c)");
    }

    public boolean checkNeighbor(Field nextField) {
        System.out.println(">checkNeighbor(nextField)");
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
        System.out.println(">setMap(m)");
        map = m;
        System.out.println("<setMap(m)");
    }
    public void setNeighbors(ArrayList<Field> fs){
        System.out.println(">setNeighbors(fs)");
        neighbors = fs;
        System.out.println("<setNeighbors(fs)");
    }
    abstract public Item getFrozenItem();

    abstract public void setFrozenItem(Item i);
}
