package hu.bme.team5;

import java.util.ArrayList;

public class Game {
    private ArrayList<Map> maps; //Mappokat tartalmazó lista
    Map currentMap; //Most futó map

    //Konstruktor
    public Game() {
        currentMap = new Map(this);
        maps = new ArrayList<>();
        maps.add(currentMap);
    }

    //Map betöltése
    public void loadMap(Map m) {
    }


    //Játék kezdése
    public void startGame() {
        System.out.println(">startGame()");
        currentMap.init();
        System.out.println("<startGame()");
    }

    //Map mentése
    public void saveMap() {
    }

    public void mapEnded(){
        
    }

    //Kilépés a játékból
    public void endGame() {
    }


}
