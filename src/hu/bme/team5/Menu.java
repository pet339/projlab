package hu.bme.team5;

/*
        ++++++++++++++++++++++++Üzenőfal+++++++++++++++++++++
        Írjátok ide ha valami eszetekbe jut, hogy majd meg kell csinálni
        Ha csinálod írd mellé a neved


        -Tent osztályt a függvényivel megcsinálni
        -FragileShovel osztályt a függvényeivel megcsinálni








*/
import java.util.Scanner;

public class Menu {
    static Game game = new Game();

    public Menu(){
        System.out.println("Valasszon esemenyt:");
        System.out.println("1. Inicializacio");
        System.out.println("2. Jatekos lep");
        System.out.println("3. Jatekos lyukba lep");    //
        System.out.println("4. Jatekos havat takarit el egy jegtablarol");
        System.out.println("5. Jatekos kias egy targyat (kotelet) egy jegtablabol");
        System.out.println("6. Jatekos atad targyat");
        System.out.println("7. Jatekos eszik");
        System.out.println("8. Sarkkutato megvizsgal egy jegtablat");
        System.out.println("9. Eszkimo iglut epit");
        System.out.println("10. Jatekos kimenti vizbe esett tarsat");
        System.out.println("11. Jatekos osszeszereli a jelzopisztolyt");
        Scanner sc = new Scanner(System.in);
        int event = 0;
        
        boolean runningGame = true;
        while(runningGame){
            try{
                event = sc.nextInt();
            }catch(Exception e){ }
            switch (event){
                case 1: {
                    game.startGame();
                } break;
                case 2: {
                    // ÁTÍRVA, Itt járok, Ákos
                    Field nextField = new Stable();
                    Character character = new Eskimo();
                    System.out.println("Mennyi munkat tud vegezni a karakter? (0-4)");
                    for (int i = 0; i < game.currentMap.characters.size(); i++){
                        game.currentMap.characters.get(i).setWork(sc.nextInt());
                    }

                    boolean b1 = character.move(nextField);
                    if (b1){
                        System.out.println("Character has succesfully moved!");
                    }
                    else{
                        System.out.println("Something went wrong at move function");
                    }

                } break;
                case 3: {
                    Field nextField = new Hole();
                    Character c = new Eskimo();
                    System.out.println("Van a karakternel buvarruha? (1/0)");
                    event = sc.nextInt();
                    if(event == 1)
                        c.inventory.addItem(new DivingSuit());
                    nextField.stepOn(c);
                } break;
                case 4: {
                    Character char4 = new Explorer();
                    Stable currentField= new Stable();
                    char4.setCurrentField(currentField);

                    System.out.println("Mekkora a horeteg vastagsaga? (0-1024)");
                    event=sc.nextInt();
                    if(event>1024) event=1024;
                    if(event<0) event=0;
                    currentField.setSnowSize(event);

                    System.out.println("Van a karakternel lapat? (1/0)");
                    event = sc.nextInt();

                    if(event==1) char4.inventory.addItem(new Shovel());

                    System.out.println("Mennyi munkat tud vegezni a karakter? (1-4)");
                    event=sc.nextInt();
                    if(event>4) event=4;
                    if(event<0) event=0;
                    char4.setWork(event);

                    boolean b4=char4.shovelSnow();

                } break;
                case 5: {
                    Character char5 = new Explorer();
                    Stable currentField= new Stable();
                    char5.setCurrentField(currentField);

                    currentField.setFrozenItem(new Rope());

                    System.out.println("Mekkora a horeteg vastagsaga? (0-1024)");
                    event=sc.nextInt();
                    if(event>1024) event=1024;
                    if(event<0) event=0;
                    currentField.setSnowSize(event);

                    System.out.println("Mennyi munkat tud vegezni a karakter? (1-4)");
                    event=sc.nextInt();
                    if(event>4) event=4;
                    if(event<0) event=0;
                    char5.setWork(event);

                    boolean b5=char5.digItem();
                } break;
                case 6: {
                    Field currentField = new Stable();
                    Character c1 = new Explorer();
                    c1.setCurrentField(currentField);
                    Item i1 = new Flare();
                    c1.inventory.addItem(i1);
                    Character c2 = new Explorer();
                    System.out.println("Azonos mezon all a ket karakter? (1/0)");
                    event = sc.nextInt();
                    if(event == 1)
                        c2.setCurrentField(currentField);
                    else
                        c2.setCurrentField(new Stable());
                    c1.trade(c2, i1);

                } break;
                case 7: {
                    Character char7 = new Explorer();
                    System.out.println("Mennyi a karakter testhője? (1-256)");
                    event=sc.nextInt();
                    if(event<1) event=1;
                    if(event>256) event=256;
                    char7.setHealth(event);
                    System.out.println("Mennyi ételt egyen?");
                    event=sc.nextInt();
                    boolean canEat=true;
                    for (int i=0; i<event; i++){
                        char7.inventory.addItem(new Food());
                        canEat = char7.eat();
                        if(!canEat) break;
                    }
                } break;
                case 8: {
                    Character exp8 = new Explorer();
                    Stable currentField = new Stable();

                    int type, capacity=0, place;
                    System.out.println("Hol vizsgaljon? (0: sajat, 1: szomszedos, 2: egyeb)");
                    place = sc.nextInt();
                    System.out.println("Milyen legyen a vizsgalt mezo? (0: lyuk, 1: instabil, 2:stabil)");
                    type=sc.nextInt();
                    if(type==1){
                        System.out.println("Mekkora legyen a teherbirasa? (0-256)");
                        capacity=sc.nextInt();
                    }
                    System.out.println("Mennyi munkat tud vegezni a karakter? (1-4)");
                    event=sc.nextInt();
                    if(event>4) event=4;
                    if(event<0) event=0;
                    exp8.setWork(event);

                    switch (type){ //Minden eset
                        case 0:{
                            Hole hole = new Hole();
                            switch (place){
                                case 0:{
                                    System.out.println("-Lyukban csak fuldokolni lehet.");
                                    exp8.setCurrentField(hole);
                                }break;
                                case 1:{
                                    exp8.setCurrentField(currentField);
                                    exp8.currentField.addNeighbor(hole);
                                }break;
                                case 2:{
                                    exp8.setCurrentField(currentField);
                                }break;
                            }
                            exp8.explore(hole);
                        }break;
                        case 1:{
                            Unstable unstable = new Unstable();
                            unstable.setCapacity(capacity);
                            switch (place){
                                case 0:{
                                    exp8.setCurrentField(unstable);
                                }break;
                                case 1:{
                                    exp8.setCurrentField(currentField);
                                    exp8.currentField.addNeighbor(unstable);
                                }break;
                                case 2:{
                                    exp8.setCurrentField(currentField);
                                }break;
                            }
                            exp8.explore(unstable);
                        }break;
                        case 2:{
                            Stable stable = new Stable();
                            switch (place){
                                case 0:{
                                    exp8.setCurrentField(stable);
                                }break;
                                case 1:{
                                    exp8.setCurrentField(currentField);
                                    exp8.currentField.addNeighbor(stable);
                                }break;
                                case 2:{
                                    exp8.setCurrentField(currentField);
                                }break;
                            }
                            exp8.explore(stable);
                        }break;
                    }
                } break;
                case 9: {
                    Character c = new Eskimo();
                    c.setCurrentField(new Stable());
                    System.out.println("Mennyi munkat tud vegezni a karakter? (0-4)");
                    c.setWork(sc.nextInt());
                    c.buildIgloo();
                } break;
                case 10: {
                    Character c1 = new Explorer();
                    c1.setCurrentField(new Stable());
                    Character c2 = new Eskimo();
                    c2.setCurrentField(new Hole());
                    System.out.println("Mennyi munkat tud vegezni a karakter? (0-4)");
                    c1.setWork(sc.nextInt());
                    System.out.println("Szomszedos mezon all a masik karakter? (1/0)");
                    event = sc.nextInt();
                    if(event == 1)
                        c1.currentField.addNeighbor(c2.currentField);
                    System.out.println("Fuldoklik a masik karakter? (1/0)");
                    event = sc.nextInt();
                    if(event == 1)
                        c2.setDrowning(true);
                    c1.saveAlly(c2);

                } break;
                case 11: {
                    Character c = new Explorer();
                    System.out.println("Mennyi munkat tud vegezni a karakter? (0-4)");
                    c.setWork(sc.nextInt());
                    System.out.println("Megvan az osszes resze a jelzopisztolynak? (1/0)");
                    event = sc.nextInt();
                    if(event == 1) {
                        c.inventory.addItem(new Flare());
                        c.inventory.addItem(new Charge());
                        c.inventory.addItem(new Gun());
                    }
                    c.assemble();
                } break;
                default: {
                    sc.close();
                    runningGame = false;
                } break;
            }
        }

    }
}
