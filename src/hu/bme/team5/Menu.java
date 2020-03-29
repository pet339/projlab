package hu.bme.team5;

import java.util.Scanner;

public class Menu {
    public Menu(){
        System.out.println("Válasszon eseményt:");
        System.out.println("1. Inicializáció");
        System.out.println("2. Játékos lép");
        System.out.println("3. Játékos havat takarít el egy jégtábláról");
        System.out.println("4. Játékos kiás egy tárgyat egy jégtáblából");
        System.out.println("5. Játékos felvesz egy tárgyat");
        System.out.println("6. Játékos eldob egy tárgyat");
        System.out.println("7. Játékos eszik");
        System.out.println("8. Sakkutató megvizsgál egy jégtáblát");
        System.out.println("9. Eszkimó iglut épít");
        System.out.println("10. Játékos kimenti vízbe esett társát");
        System.out.println("11. Játékos összeszereli a jelzőpisztolyt");
        Scanner sc = new Scanner(System.in);
        int event = 0;
        boolean runningGame = true;
        while(runningGame){
            try{
                event = sc.nextInt();
            }catch(Exception e){ }
            switch (event){
                case 1: {
                    Game game = new Game();
                    System.out.println(">game.startGame()");
                    game.startGame();
                    System.out.println("<game.startGame()");
                } break;
                case 2: break;
                case 3: break;
                case 4: break;
                case 5: break;
                case 6: break;
                case 7: break;
                case 8: break;
                case 9: break;
                case 10: break;
                case 11: break;
                default: runningGame = false; break;
            }
        }

    }
}
