package hu.bme.team5;

import javax.swing.*;
import java.awt.event.*;

public class ActionMenu extends JFrame {
    JPanel jp = new JPanel();
    JButton move = new JButton();
    JButton shovelsnow = new JButton();
    JButton saveally = new JButton();
    JButton eat = new JButton();
    JButton explore = new JButton();
    JButton buildigloo = new JButton();
    JButton trade = new JButton();
    JButton assemble = new JButton();
    JButton endturn = new JButton();
    JButton buildtent = new JButton();
    Character ch;
    Map map;


    ActionMenu(Character c,Map m) {
        ch = c;
        map = m;
        initWindow();
    }

    void initWindow() {

        this.setSize(160,350);
        move.addActionListener(new ActionMenuButtonListener());
        shovelsnow.addActionListener(new ActionMenuButtonListener());
        saveally.addActionListener(new ActionMenuButtonListener());
        eat.addActionListener(new ActionMenuButtonListener());
        explore.addActionListener(new ActionMenuButtonListener());
        buildigloo.addActionListener(new ActionMenuButtonListener());
        trade.addActionListener(new ActionMenuButtonListener());
        assemble.addActionListener(new ActionMenuButtonListener());
        endturn.addActionListener(new ActionMenuButtonListener());
        buildtent.addActionListener(new ActionMenuButtonListener());


        move.setText("Move");
        shovelsnow.setText("Shovel Snow");
        saveally.setText("Save Ally");
        eat.setText("Eat");
        explore.setText("Explore");
        buildigloo.setText("Build Igloo");
        trade.setText("Trade");
        assemble.setText("Assemble");
        endturn.setText("End Turn");
        buildtent.setText("Build Tent");


        jp.add(move);
        jp.add(shovelsnow);
        jp.add(saveally);
        jp.add(eat);
        jp.add(explore);
        jp.add(buildigloo);
        jp.add(trade);
        jp.add(assemble);
        jp.add(buildtent);
        jp.add(endturn);

        this.add(jp);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    final class ActionMenuButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals(move.getActionCommand()))
                ;

            if(e.getActionCommand().equals(shovelsnow.getActionCommand()))
                ;

            if(e.getActionCommand().equals(saveally.getActionCommand()))
                ;

            if(e.getActionCommand().equals(eat.getActionCommand()))
                ;

            if(e.getActionCommand().equals(explore.getActionCommand()))
                ;

            if(e.getActionCommand().equals(buildigloo.getActionCommand()))
                ;

            if(e.getActionCommand().equals(trade.getActionCommand()))
                ;

            if(e.getActionCommand().equals(assemble.getActionCommand()))
                ;

            if(e.getActionCommand().equals(buildtent.getActionCommand()))
                ;

            if(e.getActionCommand().equals(endturn.getActionCommand()))
                ;
        }

    }



}