package hu.bme.team5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static hu.bme.team5.Menu.game;

public class MenuView extends JFrame {

    private PlayPanel activePanel = null;
    private JButton startGame = new JButton("Start playing");
    private JFrame frame = new JFrame("Menu");
    private JFrame frame2 = new JFrame("Choose characters");
    private JPanel jp = new JPanel();
    private JButton start = new JButton();
    private JButton exit = new JButton();

    public MenuView() {
        try {
            initFrame();
            initFrame2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void initFrame2() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        startGame.addActionListener(new ActionMenuButtonListener());
        startGame.setText("Start playing");

        JPanel jPanel = new JPanel();
        JLabel label = new JLabel(("Number of characters: "));
        JComboBox comboBox = new JComboBox();
        for (int i = 0; i < 5; i++)
            comboBox.addItem(i + 1);
        jPanel.add(label);
        jPanel.add(comboBox);

        int numberOfCharacters = (int) comboBox.getSelectedItem();

        JPanel jPanel1 = new JPanel();
        JLabel label1 = new JLabel("Character 1:");
        JComboBox comboBox1 = new JComboBox();
        comboBox1.addItem("Explorer");
        comboBox1.addItem("Eskimo");
        JLabel label1_2 = new JLabel("Name:");
        JTextArea textArea1 = new JTextArea("Dora");
        textArea1.setPreferredSize(new Dimension(200, 20));
        jPanel1.add(label1);
        jPanel1.add(comboBox1);
        jPanel1.add(label1_2);
        jPanel1.add(textArea1);


        panel.add(jPanel);
        panel.add(jPanel1);

        frame2.add(startGame, BorderLayout.SOUTH);
        frame2.add(panel, BorderLayout.CENTER);
        frame2.setSize(700, 500);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void initFrame() throws IOException {

        start.addActionListener(new MenuView.ActionMenuButtonListener());
        exit.addActionListener(new MenuView.ActionMenuButtonListener());


        start.setText("Start");
        exit.setText("Exit");

        start.add(Box.createRigidArea(new Dimension(50, 10)));
        exit.add(Box.createRigidArea(new Dimension(50, 10)));


        jp.add(Box.createRigidArea(new Dimension(50, 100)));
        jp.add(start);
        jp.add(Box.createRigidArea(new Dimension(50, 30)));
        jp.add(exit);

        start.setAlignmentX(CENTER_ALIGNMENT);
        exit.setAlignmentX(CENTER_ALIGNMENT);

        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        jp.setBackground(new Color(0, 255, 255));
        frame.add(jp, BorderLayout.CENTER);
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    final class ActionMenuButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals(start.getActionCommand())) {

                frame2.setVisible(true);
                frame.setVisible(false);
            }
            if (e.getActionCommand().equals(exit.getActionCommand()))
                System.exit(0);

            if (e.getActionCommand().equals(startGame.getActionCommand())) {
                if (activePanel == null) {
                    activePanel = new PlayPanel(game.currentMap);
                    frame2.setVisible(false);
                }
            }
        }
    }
}
