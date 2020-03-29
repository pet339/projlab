package hu.bme.team5;

import java.util.ArrayList;

public class Game {
    private ArrayList<Map> maps;
    private Map currentMap;

    public Game() { }

    public void loadMap(Map m) {
    }

    public void startGame() {
        System.out.println(">currentMap.init();");
        currentMap.init();
        System.out.println("<currentMap.init();");
    }

    public void saveMap() {
    }

    public void endGame() {
    }


}
