package hu.bme.team5;

import java.util.ArrayList;
import java.util.Random;

public class Map implements TurnBased {
    // A pálya mezői
    ArrayList<Field> fields;
    // a pálya karakterei
    ArrayList<Character> characters;
    ArrayList<PolarBear> bears;
    Game game;
    Random rnd = new Random();

    boolean stormIsComing = false;
    // Map konstruktora, létrehozza a pályák és a characterek listáját
    public Map(Game g1) {
        fields = new ArrayList<Field>();
        characters = new ArrayList<Character>();
        bears = new ArrayList<PolarBear>();
        game = g1;
    }
    // Létrehoz karaktereket
    public void init() {
        // Field-ek létrehozása
        Stable field1 = new Stable();
        Unstable field2 = new Unstable();
        Stable field3 = new Stable();
        Stable field4 = new Stable();
        Hole field5 = new Hole();
        Stable field6 = new Stable();
        Stable field7 = new Stable();
        Unstable field8 = new Unstable();

        field1.capacity = 1;
        field8.capacity = 1;
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
        eskimo1.name = "Eszkimo1";
        eskimo1.setWork(4);
        eskimo1.inventory.addItem(new Food());

        Explorer explorer1 = new Explorer();
        explorer1.name ="Explorer1";
        explorer1.setWork(4);
        explorer1.inventory.addItem(new Food());

        eskimo1.currentField = field1;
        explorer1.currentField = field7;

        field1.characters.add(eskimo1);
        field7.characters.add(explorer1);


        // Jegesmedve létrehozása
        PolarBear bear = new PolarBear();
        bears.add(bear);
        bear.currentField = field4;
        field4.polarBear = true;

        // Item-ek létrehozása
        DivingSuit divingSuit = new DivingSuit();
        Tent tent = new Tent();
        Shovel shovel = new Shovel();
        Flare flare = new Flare();
        Rope rope = new Rope();
        Charge charge = new Charge();
        Gun gun = new Gun();

        // Item-ek elhelyezése
        field1.setFrozenItem(flare);
        field2.setFrozenItem(shovel);
        field3.setFrozenItem(tent);
        field4.setFrozenItem(rope);
        field6.setFrozenItem(charge);
        field7.setFrozenItem(gun);
        field8.setFrozenItem(divingSuit);

        //Fieldek hozzáadása a pályához
        fields.add(field1);
        fields.add(field2);
        fields.add(field3);
        fields.add(field4);
        fields.add(field5);
        fields.add(field6);
        fields.add(field7);
        fields.add(field8);

        characters.add(eskimo1);
        characters.add(explorer1);

        for (Field f : fields){
            f.map = this;
        }
    }

    public void startStorm() {
        System.out.println("Vihar tombol ezeken a mezokon:");
        for (Field f : game.currentMap.fields)
            if (rnd.nextInt() % 4 == 0){
                System.out.print(f.map.fields.indexOf(f) + 1 + " ");
                //Novelni a ho meretet
                f.snowSize++;
                if (!f.tent && !f.igloo){
                    for (Character c : f.characters){
                        System.out.println("");
                        c.health--;
                        System.out.println("A vihar megsebesitette: " + c.name + ", elet: " + c.health);
                        if (c.health < 1){
                            System.out.println(c.name + " kinyirta a vihar");
                            gameEnded(false);
                        }
                    }
                }
            }
        System.out.println("");
    }
    @Override
    public void endTurn() {
        for (Character c : game.currentMap.characters){
            c.endTurn();
        }
        if (stormIsComing){
            startStorm();
        }
        if (rnd.nextInt() % 2 == 0){
            stormIsComing = false;
        }
        else {
            stormIsComing = true;
        }

        for (Field f : game.currentMap.fields){
            f.tent = false;
        }
        for (PolarBear bear : game.currentMap.bears){
            bear.move();
        }

        if (stormIsComing){
            System.out.println("Vihar kozeledik");
        }
    }


    public void gameEnded(boolean win) {
        if (win){
            System.out.println("Nyertel!");
        }
        else{
            System.out.println("Vesztettel");
        }
        game.isActive = false;
    }
}
