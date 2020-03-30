package hu.bme.team5;

import java.util.ArrayList;

public class Field {
    protected ArrayList<Character> characters;
    protected ArrayList<Field> neighbors;
    protected int snowsize;

    public Field() {
    }

    public void stepOn(Character c) {
    }

    public void removeCharacter(Character c) {
    }

    public boolean checkNeighbor(Field f) {
        return true;
    }

    public void setCharacter(Character c) {
    }

    public Item getFrozenItem() {
        return null;
    }

}
