package hu.bme.team5;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PlayPanel {
    PlayPanel(){
        JFrame mainFrame = new JFrame("North Pole");

        //Characters Panel
        JPanel charactersPanel = new JPanel();
        charactersPanel.setLayout(new BoxLayout(charactersPanel,BoxLayout.Y_AXIS));

        //Gombok létrehozása a karakterPanelhez
        JButton menuButton = new JButton("Menu");
        JButton characterButton1 = new JButton("Character1");
        JButton characterButton2 = new JButton("Character2");
        JButton characterButton3 = new JButton("Character3");

        //Hozzáadás a characterPanelhez

        charactersPanel.add(menuButton);
        charactersPanel.add(Box.createRigidArea(new Dimension(0, 200)));

        charactersPanel.add(characterButton1);
        charactersPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        charactersPanel.add(characterButton2);
        charactersPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        charactersPanel.add(characterButton3);
        charactersPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        // ActionPanel letrehozasa gombokkal
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new BoxLayout(actionPanel,BoxLayout.X_AXIS));

        //ActionPanelhez gombok
        JButton spellButton = new JButton("Spell");
        JButton moveButton = new JButton("Move");
        JButton useItemButton = new JButton("Use Item");
        JButton inventoryButton = new JButton("Inventory");

        actionPanel.add(spellButton);
        actionPanel.add(Box.createRigidArea(new Dimension(60, 0)));
        actionPanel.add(moveButton);
        actionPanel.add(Box.createRigidArea(new Dimension(60, 0)));
        actionPanel.add(useItemButton);
        actionPanel.add(Box.createRigidArea(new Dimension(60, 0)));
        actionPanel.add(inventoryButton);

        // MapPanel letrehozasa gombokkal
        JPanel mapPanel = new JPanel();
        mapPanel.setBackground(Color.BLUE);

        actionPanel.setBounds(200,600,800,50);
        charactersPanel.setBounds(0,300,50,200);
        mapPanel.setBounds(200,70,950,500);


        mainFrame.add(mapPanel);
        mainFrame.add(actionPanel);
        mainFrame.add(charactersPanel);


        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setSize(1200,800);
    }

}
