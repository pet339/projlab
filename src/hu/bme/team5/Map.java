package hu.bme.team5;

import java.util.ArrayList;

public class Map implements TurnBased {
    static ArrayList<Field> fields;
    static ArrayList<Character> characters;

    public Map() {
        fields = new ArrayList<Field>();
        characters = new ArrayList<Character>();
    }

    public void init() {
        System.out.println(">init()");
        characters.add(new Eskimo());
        characters.add(new Explorer());
        System.out.println("<init()");
    }

    public void startStorm() {
    }

    @Override
    public void endTurn() {

    }

    @Override
    public void startTurn() {

    }
}
