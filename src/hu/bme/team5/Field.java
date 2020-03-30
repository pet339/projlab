package hu.bme.team5;

import java.util.ArrayList;

public class Field {
    protected ArrayList<Character> characters;
    protected ArrayList<Field> neighbors;
    protected int snowSize;

    public Field() {
    }

    public void stepOn(Character c) {
        System.out.println("    >setCharacter(c)");
        setCharacter(c);
        System.out.println("    <setCharacter(c)");

        System.out.println("    >setSnowSize(0)");
        setSnowSize(0);
        System.out.println("    <setSnowSize(0)");

        System.out.println("    >characters.get(characters.size()-1).drown()");
        characters.get(characters.size()-1).drown();

        System.out.println("    <characters.get(characters.size()-1).drown()");


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
