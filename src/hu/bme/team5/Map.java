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
    public Map(Game g1, ArrayList<Character> characters) {
        fields = new ArrayList<Field>();
        this.characters = characters;
        bears = new ArrayList<PolarBear>();
        game = g1;
        init();
    }
    // Létrehoz karaktereket
    public void init() {
        // Field-ek létrehozása
        Stable field1 = new Stable();
        Stable field2 = new Stable();
        Stable field3 = new Stable();
        Hole field4 = new Hole();
        Unstable field5 = new Unstable();
        Unstable field6 = new Unstable();
        Stable field7 = new Stable();
        Stable field8 = new Stable();
        Stable field9 = new Stable();
        Hole field10 = new Hole();
        Unstable field11 = new Unstable();
        Unstable field12 = new Unstable();
        Stable field13 = new Stable();
        Unstable field14 = new Unstable();
        Stable field15 = new Stable();
        Stable field16 = new Stable();
        Stable field17 = new Stable();
        Hole field18 = new Hole();
        Stable field19 = new Stable();

        //1
        field1.addNeighbor(field2);
        field1.addNeighbor(field3);
        field1.addNeighbor(field4);

        //2
        field2.addNeighbor(field1);
        field2.addNeighbor(field4);
        field2.addNeighbor(field5);

        //3
        field3.addNeighbor(field1);
        field3.addNeighbor(field4);
        field3.addNeighbor(field6);
        field3.addNeighbor(field7);

        //4
        field4.addNeighbor(field1);
        field4.addNeighbor(field2);
        field4.addNeighbor(field3);
        field4.addNeighbor(field5);
        field4.addNeighbor(field7);
        field4.addNeighbor(field8);

        //5
        field5.addNeighbor(field2);
        field5.addNeighbor(field4);
        field5.addNeighbor(field8);
        field5.addNeighbor(field9);

        //6
        field6.addNeighbor(field3);
        field6.addNeighbor(field7);
        field6.addNeighbor(field10);

        //7
        field7.addNeighbor(field3);
        field7.addNeighbor(field4);
        field7.addNeighbor(field6);
        field7.addNeighbor(field8);
        field7.addNeighbor(field10);
        field7.addNeighbor(field11);

        //8
        field8.addNeighbor(field4);
        field8.addNeighbor(field5);
        field8.addNeighbor(field7);
        field8.addNeighbor(field9);
        field8.addNeighbor(field11);
        field8.addNeighbor(field12);

        //9
        field9.addNeighbor(field5);
        field9.addNeighbor(field8);
        field9.addNeighbor(field12);
        field9.addNeighbor(field13);

        //10
        field10.addNeighbor(field6);
        field10.addNeighbor(field7);
        field10.addNeighbor(field11);
        field10.addNeighbor(field14);
        field10.addNeighbor(field15);

        //11
        field11.addNeighbor(field7);
        field11.addNeighbor(field8);
        field11.addNeighbor(field10);
        field11.addNeighbor(field12);
        field11.addNeighbor(field15);
        field11.addNeighbor(field16);

        //12
        field12.addNeighbor(field8);
        field12.addNeighbor(field9);
        field12.addNeighbor(field11);
        field12.addNeighbor(field13);
        field12.addNeighbor(field16);

        //13
        field13.addNeighbor(field9);
        field13.addNeighbor(field12);

        //14
        field14.addNeighbor(field10);
        field14.addNeighbor(field15);
        field14.addNeighbor(field17);

        //15
        field15.addNeighbor(field10);
        field15.addNeighbor(field11);
        field15.addNeighbor(field14);
        field15.addNeighbor(field16);
        field15.addNeighbor(field17);
        field15.addNeighbor(field18);

        //16
        field16.addNeighbor(field11);
        field16.addNeighbor(field12);
        field16.addNeighbor(field15);
        field16.addNeighbor(field18);
        field16.addNeighbor(field19);

        //17
        field17.addNeighbor(field14);
        field17.addNeighbor(field15);
        field17.addNeighbor(field18);

        //18
        field18.addNeighbor(field15);
        field18.addNeighbor(field16);
        field18.addNeighbor(field17);
        field18.addNeighbor(field19);

        //19
        field19.addNeighbor(field16);
        field19.addNeighbor(field18);

        // Jegesmedve létrehozása
        PolarBear bear = new PolarBear();
        bears.add(bear);
        bear.currentField = field7;
        field7.polarBear = true;

        // Item-ek létrehozása
        Food food1 = new Food();
        Food food2 = new Food();
        Food food3 = new Food();

        Shovel shovel = new Shovel();
        FragileShovel fragileShovel1 = new FragileShovel();
        FragileShovel fragileShovel2 = new FragileShovel();

        Flare flare = new Flare();
        Gun gun = new Gun();
        Rope rope = new Rope();
        Tent tent = new Tent();
        DivingSuit divingSuit = new DivingSuit();
        Charge charge = new Charge();


        // Item-ek elhelyezése

        //1. oszlop
        field1.setFrozenItem(flare);
        field2.setFrozenItem(shovel);

        //2. oszlop
        field3.setFrozenItem(fragileShovel1);
        field5.setFrozenItem(food1);

        //3. oszlop
        field6.setFrozenItem(food2);
        field9.setFrozenItem(rope);

        //4. oszlop
        field11.setFrozenItem(gun);
        field13.setFrozenItem(food3);

        //5. oszlop
        field14.setFrozenItem(tent);
        field16.setFrozenItem(fragileShovel2);

        //6. oszlop
        field17.setFrozenItem(divingSuit);
        field19.setFrozenItem(charge);

        //Fieldek hozzáadása a pályához
        fields.add(field1);
        fields.add(field2);
        fields.add(field3);
        fields.add(field4);
        fields.add(field5);
        fields.add(field6);
        fields.add(field7);
        fields.add(field8);
        fields.add(field9);
        fields.add(field10);
        fields.add(field11);
        fields.add(field12);
        fields.add(field13);
        fields.add(field14);
        fields.add(field15);
        fields.add(field16);
        fields.add(field17);
        fields.add(field18);
        fields.add(field19);

        //karakterek inicializalasa
        characters.get(0).setCurrentField(field1);
        field1.setCharacter(characters.get(0));

        characters.get(1).setCurrentField(field9);
        field9.setCharacter(characters.get(1));

        characters.get(2).setCurrentField(field3);
        field3.setCharacter(characters.get(2));

        if (characters.size() > 3){
            characters.get(3).setCurrentField(field19);
            field19.setCharacter(characters.get(3));
        }
        if (characters.size() > 4){
            characters.get(4).setCurrentField(field16);
            field16.setCharacter(characters.get(4));
        }









        for (Field f : fields){
            f.map = this;
        }
        //ArrayList<ArrayList<Field>> Test = FullInitTest();
    }

    public ArrayList<ArrayList<Field>> FullInitTest(){

        int mapsize = characters.size()*2;

        ArrayList<ArrayList<Field>> TFields = new ArrayList<ArrayList<Field>>();
        
        for(int i = 0 ; i <  mapsize; i++){
            ArrayList<Field> row = new ArrayList<Field>();

            for(int j = 0 ; j < mapsize; j++){
                int rando = rnd.nextInt(100);

                if(rando<=50){
                    Stable s = new Stable();
                    s.map = this;
                    int randoitem = rnd.nextInt(21);

                    if(randoitem == 0)
                        s.setFrozenItem(new Shovel());
                    if(randoitem == 1)
                        s.setFrozenItem(new Flare());
                    if(randoitem == 2)
                        s.setFrozenItem(new Gun());  
                    if(randoitem == 3)
                        s.setFrozenItem(new Charge());
                    if(randoitem == 4)
                        s.setFrozenItem(new Tent());
                    if(randoitem == 5)
                        s.setFrozenItem(new DivingSuit());
                    if(randoitem == 6)
                        s.setFrozenItem(new Rope());
                    if(randoitem == 7)
                        s.setFrozenItem(new Food());

                    row.add(j,s);
                }

                else if(rando>50 && rando<=85){
                    Unstable us = new Unstable();
                    us.map = this;
                    int randoitem = rnd.nextInt(21);

                    if(randoitem == 0)
                        us.setFrozenItem(new Shovel());
                    if(randoitem == 1)
                        us.setFrozenItem(new Flare());
                    if(randoitem == 2)
                        us.setFrozenItem(new Gun());  
                    if(randoitem == 3)
                        us.setFrozenItem(new Charge());
                    if(randoitem == 4)
                        us.setFrozenItem(new Tent());
                    if(randoitem == 5)
                        us.setFrozenItem(new DivingSuit());
                    if(randoitem == 6)
                        us.setFrozenItem(new Rope());
                    if(randoitem == 7)
                        us.setFrozenItem(new Food());

                    row.add(j,us);
                }
                    
                else{
                    Hole h = new Hole();
                    h.map = this;
                    row.add(j,h);
                }

            }
            TFields.add(i,row);
        }


        for(int i = 0 ; i < mapsize ; i++){
            for(int j = 0 ; j < mapsize ; j++){
                    try{
                        TFields.get(i).get(j).addNeighbor(TFields.get(i-1).get(j));
                    }
                    catch(IndexOutOfBoundsException e){
                        TFields.get(i).get(j).addNeighbor(null);
                    }

                    try{
                        TFields.get(i).get(j).addNeighbor(TFields.get(i-1).get(j+1));
                    }
                    catch(IndexOutOfBoundsException e){
                        TFields.get(i).get(j).addNeighbor(null);
                    }

                    try{
                        TFields.get(i).get(j).addNeighbor(TFields.get(i).get(j+1));
                    }
                    catch(IndexOutOfBoundsException e){
                        TFields.get(i).get(j).addNeighbor(null);
                    }

                    try{
                        TFields.get(i).get(j).addNeighbor(TFields.get(i+1).get(j));
                    }
                    catch(IndexOutOfBoundsException e){
                        TFields.get(i).get(j).addNeighbor(null);
                    }

                    try{
                        TFields.get(i).get(j).addNeighbor(TFields.get(i+11).get(j-1));
                    }
                    catch(IndexOutOfBoundsException e){
                        TFields.get(i).get(j).addNeighbor(null);
                    }

                    try{
                        TFields.get(i).get(j).addNeighbor(TFields.get(i).get(j-1));
                    }
                    catch(IndexOutOfBoundsException e){
                        TFields.get(i).get(j).addNeighbor(null);
                    }
                    
            }
        }
        Eskimo eskimo1 = new Eskimo();
        eskimo1.name = "Eszkimo1";
        eskimo1.setWork(4);
        eskimo1.inventory.addItem(new Food());

        Explorer explorer1 = new Explorer();
        explorer1.name ="Explorer1";
        explorer1.setWork(4);
        explorer1.inventory.addItem(new Food());

        eskimo1.currentField = TFields.get(0).get(0);
        TFields.get(0).get(0).setCharacter(eskimo1);
        
        explorer1.currentField = TFields.get(0).get(1);
        TFields.get(0).get(0).setCharacter(explorer1);
        return TFields;
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
