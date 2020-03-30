package hu.bme.team5;

import java.util.ArrayList;

public class Field {
    protected Map map;
    protected ArrayList<Character> characters;
    protected ArrayList<Field> neighbors;
    protected int snowSize;

    public Field() {
        characters = new ArrayList<Character>();
    }

    public void stepOn(Character c) {
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

    public Item getFrozenItem() {
        return null;
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
}
