package hu.bme.team5;

/*
        ++++++++++++++++++++++++Üzenőfal+++++++++++++++++++++
        Írjátok ide ha valami eszetekbe jut, hogy majd meg kell csinálni
        Ha csinálod írd mellé a neved


        -Tent osztályt a függvényivel megcsinálni
        -FragileShovel osztályt a függvényeivel megcsinálni



//JustForCommit




*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;
import static hu.bme.team5.MenuView.game;
public class Menu extends JFrame{

    public Menu(){

        Scanner sc = new Scanner(System.in);
        int event = 0;
        boolean runningGame = true;


        game.startGame();
        printOptions();
        Character active = game.currentMap.characters.get(0);
        Character passive = game.currentMap.characters.get(1);

        while(runningGame && game.isActive){
            try{
                event = sc.nextInt();
            }catch(Exception e){ }
            switch (event){
                case 1: {
                    //Játékos lép
                    System.out.println("Melyik mezore szeretne lepni?");
                    Field Chosen = game.currentMap.fields.get(sc.nextInt() - 1);


                    boolean b1 = active.move(Chosen);
                    if (b1){
                        System.out.println("Character has succesfully moved!");
                    }
                    else{
                        System.out.println("Something went wrong at move function");
                    }

                } break;
                case 2: {
                    // Hó eltakarítása
                    active.shovelSnow();

                } break;
                case 3: {
                    // Item kiásása
                    active.digItem();
                } break;
                case 4: {
                    // Item cseréje
                    if(active.inventory.items.size() > 0){
                    Item tradeItem = active.inventory.items.get(0);
                        active.trade(passive,tradeItem);
                    }
                    else
                        System.out.println("nincs targy az inventoriban");
                    
                } break;
                case 5: {
                    // Jatekos eszik
                    active.eat();
                } break;
                case 6: {
                    //Mezőt megvizsgál
                    System.out.println("Melyik mezot vizsgalja meg?");
                    Field toExlore = game.currentMap.fields.get(sc.nextInt() -1);
                    System.out.println(active.explore(toExlore));
                } break;
                case 7: {
                    // Iglut épít
                    active.buildIgloo();
                } break;
                case 8: {
                    // Karaktert megment
                    Character inTrouble = game.currentMap.characters.get(1);

                    Rope r = new Rope();
                    active.inventory.addItem(r);

                    inTrouble.move(game.currentMap.fields.get(4));
                    active.saveAlly(inTrouble);
                } break;
                case 9: {
                    // Jelzőpisztolyt összeszerel
                    active.assemble();
                } break;
                case 10: {
                    game.currentMap.endTurn();
                }break;
                case 11:{
                    sc.close();
                    runningGame = false;
                } break;
                case 12:{
                    printOptions();
                }break;
                case 13:{
                    active.inventory.writeItems();
                }break;
                case 14:{
                    // Melyik az aktív karakter, intet vár, a listában az index +1
                    System.out.println("Melyik karaktert valasztod?");
                    active = game.currentMap.characters.get(sc.nextInt() - 1);
                    // A másik a passzív karakter
                    if (active == game.currentMap.characters.get(0)){
                        passive = game.currentMap.characters.get(1);
                    }
                    else{
                        passive = game.currentMap.characters.get(0);
                    }
                    System.out.println("Uj aktiv karakter: " + active.name);
                }break;
                default: {
                    sc.close();
                    runningGame = false;
                } break;
            }
        }
    }
    public void printOptions(){
        System.out.println("Valasszon esemenyt:");
        System.out.println("1. Jatekos lep");
        System.out.println("2. Jatekos havat takarit el egy jegtablarol");
        System.out.println("3. Jatekos kias egy targyat egy jegtablabol");
        System.out.println("4. Jatekos atad targyat");
        System.out.println("5. Jatekos eszik");
        System.out.println("6. Sarkkutato megvizsgal egy jegtablat");
        System.out.println("7. Eszkimo iglut epit");
        System.out.println("8. Jatekos kimenti vizbe esett tarsat");
        System.out.println("9. Jatekos osszeszereli a jelzopisztolyt");
        System.out.println("10. Uj kor");
        System.out.println("11. Jatek befejezese");
        System.out.println("12. Menu kiirasa ujra");
        System.out.println("13. Inventory megjelenitese");
        System.out.println("14. Karakter valasztasa");
    }


}
