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
        System.out.println("3. Torolni majd");    //
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
                    System.out.println("Melyik mezore szeretne lepni?");
                    Field Chosen = game.currentMap.fields.get(sc.nextInt() - 1);


                    boolean b1 = game.currentMap.characters.get(0).move(Chosen);
                    if (b1){
                        System.out.println("Character has succesfully moved!");
                    }
                    else{
                        System.out.println("Something went wrong at move function");
                    }

                } break;
                case 4: {
                    // Hó eltakarítása
                    game.currentMap.characters.get(0).shovelSnow();

                } break;
                case 5: {
                    // Item kiásása
                    game.currentMap.characters.get(0).digItem();
                } break;
                case 6: {
                    // Item cseréje
                    Item tradeItem = game.currentMap.characters.get(0).inventory.items.get(0);
                    game.currentMap.characters.get(0).trade(game.currentMap.characters.get(1),tradeItem);
                } break;
                case 7: {
                    // Jatekos eszik
                    game.currentMap.characters.get(0).eat();
                } break;
                case 8: {
                    System.out.println("Melyik mezot vizsgalja meg?");
                    Field toExlore = game.currentMap.fields.get(sc.nextInt() -1);
                    game.currentMap.characters.get(0).explore(toExlore);
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
