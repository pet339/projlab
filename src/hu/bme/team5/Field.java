package hu.bme.team5;

import java.util.ArrayList;

public class Field {
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

    public boolean checkNeighbor(Field f) {
        return true;
    }

    public void setCharacter(Character c) {
        characters.add(c);
    }

    public Item getFrozenItem() {
        return null;
    }

    void setSnowSize(int s){
        snowSize = s;
    }
}
