package hu.bme.team5;

import java.util.ArrayList;

public class Map implements TurnBased {
    // A pálya mezői
    static ArrayList<Field> fields;
    // a pálya karakterei
    static ArrayList<Character> characters;
    private static Game g;

    // Map konstruktora, létrehozza a pályák és a characterek listáját
    public Map(Game g1) {
        fields = new ArrayList<Field>();
        characters = new ArrayList<Character>();
        g = g1;
    }
    // Létrehoz karaktereket
    public void init() {
        System.out.println(">init()");
        //karakterekhez ad egy eskimot
        characters.add(new Eskimo());
        //karakterekhez ad egy explorer-t
        characters.add(new Explorer());
        System.out.println("<init()");

        // Field-ek létrehozása
        Unstable field1 = new Unstable();
        Stable field2 = new Stable();
        Stable field3 = new Stable();
        Stable field4 = new Stable();
        Hole field5 = new Hole();
        Stable field6 = new Stable();
        Stable field7 = new Stable();
        Unstable field8 = new Unstable();

        //Szomszédokkal összekötés

        //Field1
        field1.addNeighbor(field2);
        field1.addNeighbor(field3);

        //Field2
        field2.addNeighbor(field1);
        field2.addNeighbor(field3);
        field2.addNeighbor(field4);
        field2.addNeighbor(field5);

        //Field3
        field3.addNeighbor(field1);
        field3.addNeighbor(field2);
        field3.addNeighbor(field5);
        field3.addNeighbor(field6);

        //Field4
        field4.addNeighbor(field2);
        field4.addNeighbor(field5);
        field4.addNeighbor(field8);

        //Field5
        field5.addNeighbor(field2);
        field5.addNeighbor(field3);
        field5.addNeighbor(field4);
        field5.addNeighbor(field6);
        field5.addNeighbor(field7);
        field5.addNeighbor(field8);

        //Field6
        field6.addNeighbor(field3);
        field6.addNeighbor(field5);
        field6.addNeighbor(field7);

        //Field7
        field7.addNeighbor(field5);
        field7.addNeighbor(field6);
        field7.addNeighbor(field8);

        //Field8
        field8.addNeighbor(field4);
        field8.addNeighbor(field5);
        field8.addNeighbor(field7);

        // Karakterek létrehozása
        Eskimo eskimo1 = new Eskimo();
        Explorer explorer1 = new Explorer();

        eskimo1.currentField = field1;
        explorer1.currentField = field7;

        // Jegesmedve létrehozása
        PolarBear bear = new PolarBear();
        bear.currentField = field4;

        // Item-ek létrehozása
        DivingSuit divingSuit = new DivingSuit();
        Tent tent = new Tent();
        FragileShovel fragileShovel = new FragileShovel();

        // Item-ek elhelyezése
        field3.setFrozenItem(tent);
        field4.setFrozenItem(fragileShovel);
        field8.setFrozenItem(divingSuit);



    }

    public void startStorm() {
    }

    @Override
    public void endTurn() {

    }

    @Override
    public void startTurn() {

    }


    public void GameEnded(boolean win) {
        
    }
}
