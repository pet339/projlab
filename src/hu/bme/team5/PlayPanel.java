package hu.bme.team5;

import javax.swing.*;
import java.awt.*;

public class PlayPanel {
    PlayPanel(){
        JFrame mainFrame = new JFrame("North Pole");

        //Characters Panel
        JPanel charactersPanel = new JPanel();
        charactersPanel.setLayout(new BoxLayout(charactersPanel,BoxLayout.Y_AXIS));

        //Gombok létrehozása a karakterPanelhez
        JButton characterButton1 = new JButton("Character1");
        JButton characterButton2 = new JButton("Character2");
        JButton characterButton3 = new JButton("Character3");
        JButton menuButton = new JButton("Menu");


        //Hozzáadás a characterPanelhez

        charactersPanel.add(menuButton);

        charactersPanel.add(characterButton1);
        charactersPanel.add(characterButton2);
        charactersPanel.add(characterButton3);


        mainFrame.add(charactersPanel, BorderLayout.WEST);
        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setSize(1200,800);
    }

}
