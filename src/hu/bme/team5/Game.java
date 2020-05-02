package hu.bme.team5;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.*;

public class Game extends JFrame {
    private ArrayList<Map> maps; //Mappokat tartalmazó lista
    Map currentMap; //Most futó map
    boolean isActive;

    JPanel jp = new JPanel();
    JButton loadmap = new JButton();
    JButton savemap = new JButton();
    JButton startgame = new JButton();
    JButton endgame = new JButton();

    //Konstruktor
    public Game() {
        
        currentMap = new Map(this);
        maps = new ArrayList<>();
        maps.add(currentMap);
        isActive = true;

        initWindow();
    }

    private void initWindow() {
        
        this.setSize(200,200);

        loadmap.setText("Load Map");
        savemap.setText("Save Current Map");
        startgame.setText("Start Game");
        endgame.setText("End Game");

        loadmap.addActionListener(new MenuButtonListener());
        savemap.addActionListener(new MenuButtonListener());
        startgame.addActionListener(new MenuButtonListener());
        endgame.addActionListener(new MenuButtonListener());

        
        jp.add(startgame);
        jp.add(loadmap);
        jp.add(savemap);
        jp.add(endgame);


        this.add(jp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        setVisible(true);

    }

    final class MenuButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals(loadmap.getActionCommand())){
                loadMap(null);
            }
            if(e.getActionCommand().equals(savemap.getActionCommand())){
                saveMap();
            }
            if(e.getActionCommand().equals(startgame.getActionCommand())){
                startGame();
            }
            if(e.getActionCommand().equals(endgame.getActionCommand())){
                endGame();
            }
            
        }

    }

    //Map betöltése
    public void loadMap(Map m) {
    }


    //Játék kezdése
    public void startGame() {
        currentMap.init();
        System.out.println("lol");
    }

    //Map mentése
    public void saveMap() {
    }

    public void mapEnded(){
        
    }

    //Kilépés a játékból
    public void endGame() {
        this.dispose();
    }


}
