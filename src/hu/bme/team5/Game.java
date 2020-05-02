package hu.bme.team5;

import javax.swing.*;
import java.util.ArrayList;

public class Game extends JFrame {
    private ArrayList<Map> maps; //Mappokat tartalmazó lista
    Map currentMap; //Most futó map
    boolean isActive;

    //Konstruktor
    public Game() {
        currentMap = new Map(this);
        maps = new ArrayList<>();
        maps.add(currentMap);
        isActive = true;

        initWindow();
    }

    private void initWindow() {

        JPanel jp = new JPanel();
        this.add(jp);
        setVisible(true);
    }

    //Map betöltése
    public void loadMap(Map m) {
    }


    //Játék kezdése
    public void startGame() {
        currentMap.init();
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
