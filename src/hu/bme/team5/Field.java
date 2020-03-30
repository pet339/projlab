package hu.bme.team5;

import java.util.ArrayList;

public class Field {
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
        characters.remove(c);
    }

    public boolean checkNeighbor(Field nextField) {
        System.out.println(">currentField.checkNeighbor(nextField)");
        System.out.println("<currentField.checkNeighbor(nextField)");
        return false;
    }

    public void setCharacter(Character c) {
        characters.add(c);
    }

    public Item getFrozenItem() {
        return null;
    }

    void setSnowSize(int s){
        System.out.println(">setSnowSize(s)");
        snowSize = s;
        System.out.println(">setSnowSize(s)");
    }
}
