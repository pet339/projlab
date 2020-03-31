package hu.bme.team5;

import java.util.ArrayList;

public class Map implements TurnBased {
    // A pálya mezői
    static ArrayList<Field> fields;
    // a pálya karakterei
    static ArrayList<Character> characters;

    // Map konstruktora, létrehozza a pályák és a characterek listáját
    public Map() {
        fields = new ArrayList<Field>();
        characters = new ArrayList<Character>();
    }
    // Létrehoz karaktereket
    public void init() {
        System.out.println(">init()");
        //karakterekhez ad egy eskimot
        characters.add(new Eskimo());
        //karakterekhez ad egy explorer-t
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
