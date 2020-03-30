package hu.bme.team5;

import java.util.ArrayList;

public class Game {
    private ArrayList<Map> maps;
    Map currentMap;

    public Game() {
        currentMap = new Map();
        maps = new ArrayList<>();
        maps.add(currentMap);
    }

    public void loadMap(Map m) {
    }

    public void startGame() {
        System.out.println(">startGame()");
        currentMap.init();
        System.out.println("<startGame()");
    }

    public void saveMap() {
    }

    public void endGame() {
    }


}
