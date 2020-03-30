package hu.bme.team5;

import java.util.Scanner;

public class Menu {
    static Game game = new Game();

    public Menu(){
        System.out.println("Valasszon esemenyt:");
        System.out.println("1. Inicializacio");
        System.out.println("2. Jatekos lep");
        System.out.println("3. Jatekos lyukba lep");
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
                    Field nextField = new Stable();
                    Character character = new Eskimo();
                    boolean b1 = character.move(nextField);

                } break;
                case 3: {
                    Field nextField = new Hole();
                    Character c = new Eskimo();
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
                } break;
                case 7: break;
                case 8: break;
                case 9: break;
                case 10: break;
                case 11: break;
                case 12: break;
                default: {
                    sc.close();
                    runningGame = false;
                } break;
            }
        }

    }
}
