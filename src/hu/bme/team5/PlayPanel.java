package hu.bme.team5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlayPanel {
    Map map;
    Character selectedChar;
    JComboBox characterComboBox, characterComboBox2;
    JComboBox tradeCharacterComboBox;
    JComboBox itemComboBox;
    String itemNames[], characterNames[];
    DefaultComboBoxModel<String> itemModel, characterModel;

    Field selectedField = null;

    JLabel healthLabel = new JLabel("Health: 0");
    JLabel workLabel = new JLabel("Work: 0");
    JButton itemOkButton = new JButton("Ok");

    JButton spellButton = new JButton("Spell");
    JButton moveButton = new JButton("Move");
    JButton endTurnButton = new JButton("End Turn");

    JFrame mainFrame = new JFrame("North Pole");

    HexagonMapPanel hexagonMapPanel = null;

    public PlayPanel(Map m) {
        System.out.println(m.characters.get(0));
        this.map = m;
        hexagonMapPanel = new HexagonMapPanel(m);
        hexagonMapPanel.addMouseListener(new MouseClickedListener());
        selectedChar = m.characters.get(0);
        healthLabel.setText("Health: " + selectedChar.health);
        workLabel.setText("Work: " + selectedChar.work);


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
        String[] tempitems = {"Save Ally", "Eat", "Shovel", "Assamble" };
        itemComboBox = new JComboBox(tempitems);
        itemComboBox.setSize(100, itemComboBox.getPreferredSize().height);
        itemComboBox.addActionListener(new ItemActionChosenListener());

        //Hozzáadás a characterPanelhez
        //charactersPanel.add(menuButton);

        charactersPanel.add(characterComboBox,BorderLayout.WEST);

        // ActionPanel letrehozasa gombokkal
        JPanel actionPanel = new JPanel();
        actionPanel.setBounds(0, 400, 300, 100);
        actionPanel.setLayout(new BoxLayout(actionPanel, BoxLayout.Y_AXIS));


        //ActionPanelhez gombok
        spellButton.setActionCommand("Spell");
        spellButton.addActionListener(new ButtonListener());

        moveButton.setActionCommand("Move");
        moveButton.addActionListener(new ButtonListener());



        actionPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        actionPanel.add(spellButton);
        actionPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        actionPanel.add(moveButton);
        actionPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        //HexagonMap Panel létrehozása
        hexagonMapPanel.setBounds(180,50,600,550);
        //InfoPanel létrehozása
        JPanel infoPanel = new JPanel();
        infoPanel.setBounds(0,150,180,100);

        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));



        healthLabel.setFont(new Font("Serif", Font.BOLD, 24));
        workLabel.setFont(new Font("Serif", Font.BOLD, 24));

        infoPanel.add(healthLabel);
        infoPanel.add(Box.createRigidArea(new Dimension(0, 7)));
        infoPanel.add(workLabel);


        //MessagePanel
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
        JLabel messageLabel = new JLabel("Message:");
        messageLabel.setFont(new Font("Serif", Font.BOLD, 24));

        messagePanel.setBounds(0,280,180,200);
        messagePanel.add(messageLabel);

        messagePanel.add(Box.createRigidArea(new Dimension(0, 15)));
        JLabel messageInformLabel = new JLabel("Keep Playing!");
        messagePanel.add(messageInformLabel);

        // InventoryPanel létrehozása
        JPanel inventoryPanel = new JPanel();
        inventoryPanel.setBounds(800,75,375, 500);

        inventoryPanel.setLayout(new GridLayout(4,3));
        inventoryPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        for(Item i : selectedChar.inventory.items){
            final JLabel label = new JLabel();
            label.setIcon(new ImageIcon(i.draw()));
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

        //TradeItem Panel
        JPanel tradeItemPanel = new JPanel();
        tradeItemPanel.setLayout(new BoxLayout(tradeItemPanel, BoxLayout.X_AXIS));
        JLabel tradeItem = new JLabel("Trade:");
        tradeItem.setFont(new Font("Serif", Font.BOLD, 24));

        tradeItemPanel.setBounds(0,520,610,50);

        tradeItemPanel.add(tradeItem);
        tradeItemPanel.add(Box.createRigidArea(new Dimension(36, 0)));

        itemNames = new String[selectedChar.inventory.items.size()];
        for (int i = 0; i < selectedChar.inventory.items.size();i++){
            itemNames[i] = selectedChar.inventory.items.get(i).name;
        }

        itemModel = new DefaultComboBoxModel<>(itemNames);
        JComboBox<String> itemComboBox2 = new JComboBox<>(itemModel);


        //KarakterComboBox2
        characterNames = new String[map.characters.size() -1];
        int counter = 0;
        for (int i = 0; i < map.characters.size();i++){
            if (selectedChar.name != map.characters.get(i).name)
                characterNames[counter++] = map.characters.get(i).name;
        }


        itemComboBox2.setSize(100, characterComboBox.getPreferredSize().height);
        tradeItemPanel.add(itemComboBox2);

        tradeItemPanel.add(Box.createRigidArea(new Dimension(70, 0)));

        characterModel = new DefaultComboBoxModel<>(characterNames);
        JComboBox<String> characterComboBox2 = new JComboBox<>(characterModel);

        tradeItemPanel.add(characterComboBox2);

        tradeItemPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        JButton tradeOkButton = new JButton("Ok");
        tradeItemPanel.add(tradeOkButton);






        // ItemPanel
        JPanel itemPanel = new JPanel();

        itemPanel.setBounds(0,600,747,50);
        itemPanel.setLayout(new BoxLayout(itemPanel,BoxLayout.X_AXIS));

        JLabel useItem = new JLabel("Do it:");
        useItem.setFont(new Font("Serif", Font.BOLD, 24));


        itemPanel.add(useItem);

        itemPanel.add(Box.createRigidArea(new Dimension(47, 0)));
        //Rossz meg, holnapra

        itemPanel.add(itemComboBox);

        itemPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        itemOkButton.setActionCommand("Ok");
        itemOkButton.addActionListener(new ItemActionChosenListener());
        itemPanel.add(itemOkButton);


        endTurnButton.setActionCommand("End Turn");
        endTurnButton.addActionListener(new ButtonListener());
        itemPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        itemPanel.add(endTurnButton);


        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setSize(1185, 690);


        mainFrame.add(tradeItemPanel);
        mainFrame.add(inventoryTextPanel);
        mainFrame.add(infoPanel);
        mainFrame.add(menuPanel);
        mainFrame.add(charactersPanel);
        mainFrame.add(hexagonMapPanel);
        mainFrame.add(actionPanel);
        mainFrame.add(inventoryPanel);
        mainFrame.add(itemPanel);
        mainFrame.add(messagePanel);



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
                    selectedChar = map.characters.get(i);
                healthLabel.setText("Health: " + selectedChar.health);
                workLabel.setText("Work: " + selectedChar.work);
            }

            itemModel.removeAllElements();
            String itemNames[] = new String[selectedChar.inventory.items.size()];
            for (int i = 0; i < selectedChar.inventory.items.size();i++){
                itemNames[i] = selectedChar.inventory.items.get(i).name;
                itemModel.addElement(selectedChar.inventory.items.get(i).name);
            }

            characterModel.removeAllElements();
            characterNames = new String[map.characters.size() -1];
            int counter = 0;
            for (int i = 0; i < map.characters.size();i++){
                if (selectedChar.name != map.characters.get(i).name){
                    characterNames[counter++] = map.characters.get(i).name;
                    characterModel.addElement(map.characters.get(i).name);
                }


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
                        selectedChar.saveAlly(selectedChar);
                        workLabel.setText("Work: " + selectedChar.work);
                    }


                    case "Eat": {
                        selectedChar.eat();
                        healthLabel.setText("Health: " + selectedChar.health);
                    }


                    case "Shovel": {
                        selectedChar.shovelSnow();
                        workLabel.setText("Work: " + selectedChar.work);
                    }


                    case "Assemble": {
                        selectedChar.assemble();
                        workLabel.setText("Work: " + selectedChar.work);
                    }


                }
            }


        }

    }

    final class MouseClickedListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            for (Field f : hexagonMapPanel.m.fields) {
                if (f.p.contains(mouseEvent.getX(), mouseEvent.getY())) {
                    f.getExplored(hexagonMapPanel.getGraphics());

                    selectedField = f;
                    System.out.println(selectedField.getId());

                }
            }
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

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
                selectedChar.Spell(selectedChar.currentField);
                workLabel.setText("Work: " + selectedChar.work);
            }
            if (e.getActionCommand().equals("Move")) {
                if (selectedField != null) {
                    selectedChar.move(selectedField);
                    workLabel.setText("Work: " + selectedChar.work);
                }

            }
            if (e.getActionCommand().equals("Trade")) {
                //SelectedChar.trade();
                workLabel.setText("Work: " + selectedChar.work);

            }
            if (e.getActionCommand().equals("End Turn")) {
                map.endTurn();
            }

        }
    }

}
