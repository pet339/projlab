package hu.bme.team5;

import java.util.Scanner;

public class Menu {
    static Game game = new Game();

    public Menu(){
        System.out.println("Valasszon esemenyt:");
        System.out.println("1. Inicializacio");
        System.out.println("2. Jatekos lep");
        System.out.println("3. Jatekos havat takarit el egy jegtablarol");
        System.out.println("4. Jatekos kias egy targyat egy jegtablabol");
        System.out.println("5. Jatekos felvesz egy targyat");
        System.out.println("6. Jatekos eldob egy targyat");
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
                    System.out.println(">game.startGame()");
                    game.startGame();
                    System.out.println("<game.startGame()");
                } break;
                case 2: {
                    Field nextField = new Field();
                    System.out.println(">game.currentMap.characters.get(0).move(nextField)");
                    boolean b1 = game.currentMap.characters.get(0).move(nextField);
                    System.out.println("<game.currentMap.characters.get(0).move(nextField)");

                } break;
                case 3: {
                    Field nextField = new Hole();
                    System.out.println(">nextField.stepOn(game.currentMap.characters.get(0))");
                    nextField.stepOn(game.currentMap.characters.get(0));





                    System.out.println("<nextField.stepOn(game.currentMap.characters.get(0))");
                } break;
                case 4: break;
                case 5: break;
                case 6: break;
                case 7: break;
                case 8: break;
                case 9: break;
                case 10: break;
                case 11: break;
                default: {
                    sc.close();
                    runningGame = false;
                } break;
            }
        }

    }
}
