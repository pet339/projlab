package hu.bme.team5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayPanel {
    Map m;
    Character SelectedChar;
    JComboBox cbchars;
    JComboBox cbitems;
    public PlayPanel(Map m) {
        SelectedChar = m.characters.get(0);
        JFrame mainFrame = new JFrame("North Pole");
        this.m = m;
        //Characters Panel
        JPanel charactersPanel = new JPanel();
        charactersPanel.setLayout(new BoxLayout(charactersPanel, BoxLayout.Y_AXIS));

        //Gombok létrehozása a karakterPanelhez
        JButton menuButton = new JButton("Menu");
        JButton characterButton1 = new JButton("Character1");
        JButton characterButton2 = new JButton("Character2");
        JButton characterButton3 = new JButton("Character3");

        //characters combo box init
        
        String[] tempchars = new String[m.characters.size()];
        for(int i = 0 ; i < m.characters.size();i++){
            tempchars[i] = m.characters.get(i).name;
        }
        cbchars = new JComboBox(tempchars);
        cbchars.addActionListener(new CharacterChangedActionListener());


        //items combo box init
        String[] tempitems = {"Save Ally", "Eat", "Shovel Snow", "Assemble flaregun" };
         cbitems = new JComboBox(tempitems);
         cbitems.addActionListener(new ItemActionChosenListener());
        
        //Hozzáadás a characterPanelhez

        charactersPanel.add(menuButton);
        charactersPanel.add(Box.createRigidArea(new Dimension(0, 200)));
        

        // ActionPanel letrehozasa gombokkal
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new BoxLayout(actionPanel,BoxLayout.X_AXIS));

        //ActionPanelhez gombok
        
        JButton spellButton = new JButton("Spell");
        JButton moveButton = new JButton("Move");
        JButton useItemButton = new JButton("Use Item");
        JButton inventoryButton = new JButton("Inventory");
        JButton tradeButton = new JButton("Trade");

        actionPanel.add(spellButton);
        actionPanel.add(Box.createRigidArea(new Dimension(80, 0)));
        actionPanel.add(moveButton);
        actionPanel.add(Box.createRigidArea(new Dimension(80, 0)));
        actionPanel.add(useItemButton);
        actionPanel.add(Box.createRigidArea(new Dimension(80, 0)));
        actionPanel.add(inventoryButton);
        actionPanel.add(Box.createRigidArea(new Dimension(80, 0)));
        actionPanel.add(tradeButton);



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

    final class CharacterChangedActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String s = (String) cbchars.getSelectedItem();

            for(int i = 0 ; i < m.characters.size(); i++){
                if(m.characters.get(i).name.equals(s))
                    SelectedChar = m.characters.get(i);
            }
        }

    }

    final class ItemActionChosenListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String s = (String) cbitems.getSelectedItem();
            
            switch(s) {
                case "Save Ally":
                    SelectedChar.saveAlly(SelectedChar);
                case "Eat":
                    SelectedChar.eat();
                case "Shovel Snow":
                    SelectedChar.shovelSnow();
                case "Assemble flaregun":
                    SelectedChar.assemble();
            }

        }

    }

}
