package hu.bme.team5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayPanel {
    Map map;
    Character SelectedChar;
    JComboBox characterComboBox;
    JComboBox itemComboBox;
    JLabel healthLabel = new JLabel("Health: 0");
    JLabel workLabel = new JLabel("Work: 0");
    JButton itemOkButton = new JButton("Ok");

    JButton spellButton = new JButton("Spell");
    JButton moveButton = new JButton("Move");
    JButton tradeButton = new JButton("Trade");
    JButton endTurnButton = new JButton("End Turn");

    JFrame mainFrame = new JFrame("North Pole");

    public PlayPanel(Map m) {
        System.out.println(m.characters.get(0));
        this.map = m;
        SelectedChar = m.characters.get(0);
        healthLabel.setText("Health: " + SelectedChar.health);
        workLabel.setText("Work: " + SelectedChar.work);


        //Characters Panel
        JPanel charactersPanel = new JPanel(new BorderLayout());
        charactersPanel.setBounds(0, 100, 180, 25);


        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.X_AXIS));
        menuPanel.setBounds(0, 0, 1300, 30);


        //Gombok létrehozása a karakterPanelhez
        JButton newGameButton = new JButton("New Game");
        newGameButton.setActionCommand("New Game");
        newGameButton.addActionListener(new ButtonListener());

        JButton exitGameButton = new JButton("Exit");
        exitGameButton.setActionCommand("Exit");
        exitGameButton.addActionListener(new ButtonListener());


        menuPanel.add(newGameButton);
        menuPanel.add(Box.createRigidArea(new Dimension(1016, 0)));
        menuPanel.add(exitGameButton);

        //characters combo box init
        String[] tempchars = new String[m.characters.size()];
        for (int i = 0; i < m.characters.size(); i++) {
            tempchars[i] = m.characters.get(i).name;
        }

        characterComboBox = new JComboBox(tempchars);
        characterComboBox.setSize(100, characterComboBox.getPreferredSize().height);
        characterComboBox.addActionListener(new CharacterChangedActionListener());


        //items combo box init
        String[] tempitems = {"Rope", "Food", "Shovel", "Gun" };
        itemComboBox = new JComboBox(tempitems);
        itemComboBox.setSize(100, itemComboBox.getPreferredSize().height);
        itemComboBox.addActionListener(new ItemActionChosenListener());
        
        //Hozzáadás a characterPanelhez
        //charactersPanel.add(menuButton);

        charactersPanel.add(characterComboBox,BorderLayout.WEST);


        // ActionPanel letrehozasa gombokkal
        JPanel actionPanel = new JPanel();
        actionPanel.setBounds(0, 400, 300, 200);
        actionPanel.setLayout(new BoxLayout(actionPanel, BoxLayout.Y_AXIS));


        //ActionPanelhez gombok
        spellButton.setActionCommand("Spell");
        spellButton.addActionListener(new ButtonListener());

        moveButton.setActionCommand("Move");
        moveButton.addActionListener(new ButtonListener());

        tradeButton.setActionCommand("Trade");
        tradeButton.addActionListener(new ButtonListener());

        actionPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        actionPanel.add(spellButton);
        actionPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        actionPanel.add(moveButton);
        actionPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        actionPanel.add(tradeButton);


        //HexagonMap Panel létrehozása
        HexagonMapPanel hexagonMapPanel = new HexagonMapPanel(m);
        hexagonMapPanel.setBounds(180,50,600,550);
        //InfoPanel létrehozása
        JPanel infoPanel = new JPanel();
        infoPanel.setBounds(0,250,180,170);

        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));



        healthLabel.setFont(new Font("Serif", Font.BOLD, 24));
        workLabel.setFont(new Font("Serif", Font.BOLD, 24));

        infoPanel.add(healthLabel);
        infoPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        infoPanel.add(workLabel);

        // InventoryPanel létrehozása
        JPanel inventoryPanel = new JPanel();
        inventoryPanel.setBounds(800,75,375, 500);

        inventoryPanel.setLayout(new GridLayout(4,3));
        inventoryPanel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));

        for (int i =0; i<(4*3); i++){
            final JLabel label = new JLabel("Label");
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            inventoryPanel.add(label);
        }


        //inventoryLabel.setFont(new Font("Serif", Font.BOLD, 24));
        //inventoryLabel.setAlignmentX( Component.LEFT_ALIGNMENT );

        //inventoryPanel.add(inventoryLabel);

        JPanel inventoryTextPanel = new JPanel();
        JLabel inventoryLabel = new JLabel("Inventory");
        inventoryLabel.setFont(new Font("Serif", Font.BOLD, 24));

        inventoryTextPanel.setBounds(940,30,100,35);
        inventoryTextPanel.add(inventoryLabel);



        // ItemPanel
        JPanel itemPanel = new JPanel();

        itemPanel.setBounds(0,600,600,50);
        itemPanel.setLayout(new BoxLayout(itemPanel,BoxLayout.X_AXIS));



        JLabel useItem = new JLabel("Use Item:");
        useItem.setFont(new Font("Serif", Font.BOLD, 24));


        itemPanel.add(useItem);

        itemPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        //Rossz meg, holnapra

        itemPanel.add(itemComboBox);

        itemPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        itemOkButton.setActionCommand("Ok");
        itemOkButton.addActionListener(new ItemActionChosenListener());
        itemPanel.add(itemOkButton);

        endTurnButton.setActionCommand("End Turn");
        endTurnButton.addActionListener(new ButtonListener());
        itemPanel.add(Box.createRigidArea(new Dimension(150, 0)));
        itemPanel.add(endTurnButton);


        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setSize(1185, 690);

        mainFrame.add(inventoryTextPanel);
        mainFrame.add(infoPanel);
        mainFrame.add(menuPanel);
        mainFrame.add(charactersPanel);
        mainFrame.add(hexagonMapPanel);
        mainFrame.add(actionPanel);
        mainFrame.add(inventoryPanel);
        mainFrame.add(itemPanel);

        //csak hogy ne romoljon el az utolsonal
        JPanel empty = new JPanel();
        mainFrame.add(empty);

    }

    final class CharacterChangedActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String s = (String) characterComboBox.getSelectedItem();

            for(int i = 0 ; i < map.characters.size(); i++) {
                if (map.characters.get(i).name.equals(s))
                    SelectedChar = map.characters.get(i);
                healthLabel.setText("Health: " + SelectedChar.health);
                workLabel.setText("Work: " + SelectedChar.work);
            }
        }

    }

    final class ItemActionChosenListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String s = (String) itemComboBox.getSelectedItem();
            if (e.getActionCommand().equals("Ok")) {
                switch (s) {
                    case "Save Ally": {
                        SelectedChar.saveAlly(SelectedChar);
                        workLabel.setText("Work: " + SelectedChar.work);
                    }


                    case "Eat": {
                        SelectedChar.eat();
                        healthLabel.setText("Health: " + SelectedChar.health);
                    }


                    case "Shovel Snow": {
                        SelectedChar.shovelSnow();
                        workLabel.setText("Work: " + SelectedChar.work);
                    }


                    case "Assemble flaregun": {
                        SelectedChar.assemble();
                        workLabel.setText("Work: " + SelectedChar.work);
                    }


                }
            }


        }

    }

    final class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Exit"))
                System.exit(0);
            if (e.getActionCommand().equals("New Game")) {
                mainFrame.setVisible(false);
                MenuView menuView = new MenuView();
            }
            if (e.getActionCommand().equals("Spell")) {
                //SelectedChar.spell()
                workLabel.setText("Work: " + SelectedChar.work);
            }
            if (e.getActionCommand().equals("Move")) {
                //SelectedChar.move()
                workLabel.setText("Work: " + SelectedChar.work);
            }
            if (e.getActionCommand().equals("Trade")) {
                //SelectedChar.trade();
                workLabel.setText("Work: " + SelectedChar.work);
            }
            if (e.getActionCommand().equals("End Turn")) {
                map.endTurn();
            }

        }
    }

}
