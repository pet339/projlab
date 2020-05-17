package hu.bme.team5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuView extends JFrame {

    private PlayPanel activePanel = null;
    private JButton startGame = new JButton("Start playing");
    private JFrame frame = new JFrame("North Pole");
    static Game game;
    JPanel jPanel3, jPanel4, jPanel5;

    JComboBox comboBox;
    public MenuView() {
        initframe();
    }

    void initframe() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        startGame.addActionListener(new ActionMenuButtonListener());
        startGame.setText("Start playing");

        JPanel jPanel = new JPanel();
        JLabel label = new JLabel(("Number of characters: "));
        comboBox = new JComboBox();
        comboBox.addItem(3);
        comboBox.addItem(4);
        comboBox.addItem(5);
        jPanel.add(label);
        jPanel.add(comboBox);
        comboBox.addActionListener(new comboBoxListener());

        //int numberOfCharacters = (int) comboBox.getSelectedItem();

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


        JPanel jPanel2 = new JPanel();
        JLabel label2 = new JLabel("Character 2:");
        JComboBox comboBox2 = new JComboBox();
        comboBox2.addItem("Explorer");
        comboBox2.addItem("Eskimo");
        JLabel label2_2 = new JLabel("Name:");
        JTextArea textArea2 = new JTextArea("Indiana Jones");
        textArea2.setPreferredSize(new Dimension(200, 20));
        jPanel2.add(label2);
        jPanel2.add(comboBox2);
        jPanel2.add(label2_2);
        jPanel2.add(textArea2);

        jPanel3 = new JPanel();
        JLabel label3 = new JLabel("Character 3:");
        JComboBox comboBox3 = new JComboBox();
        comboBox3.addItem("Explorer");
        comboBox3.addItem("Eskimo");
        JLabel label3_2 = new JLabel("Name:");
        JTextArea textArea3 = new JTextArea("Christopher Colombus");
        textArea3.setPreferredSize(new Dimension(200, 20));
        jPanel3.add(label3);
        jPanel3.add(comboBox3);
        jPanel3.add(label3_2);
        jPanel3.add(textArea3);

        jPanel4 = new JPanel();
        JLabel label4 = new JLabel("Character 4:");
        JComboBox comboBox4 = new JComboBox();
        comboBox4.addItem("Explorer");
        comboBox4.addItem("Eskimo");
        JLabel label4_2 = new JLabel("Name:");
        JTextArea textArea4 = new JTextArea("Ragnar Lothbrok");
        textArea4.setPreferredSize(new Dimension(200, 20));
        jPanel4.add(label4);
        jPanel4.add(comboBox4);
        jPanel4.add(label4_2);
        jPanel4.add(textArea4);

        jPanel4.setVisible(false);

        jPanel5 = new JPanel();
        JLabel label5 = new JLabel("Character 5:");
        JComboBox comboBox5 = new JComboBox();
        comboBox5.addItem("Explorer");
        comboBox5.addItem("Eskimo");
        JLabel label5_2 = new JLabel("Name:");
        JTextArea textArea5 = new JTextArea("Eric The Red");
        textArea5.setPreferredSize(new Dimension(200, 20));
        jPanel5.add(label5);
        jPanel5.add(comboBox5);
        jPanel5.add(label5_2);
        jPanel5.add(textArea5);

        jPanel5.setVisible(false);


        panel.add(jPanel);
        panel.add(jPanel1);
        panel.add(jPanel2);
        panel.add(jPanel3);
        panel.add(jPanel4);
        panel.add(jPanel5);

        frame.add(startGame, BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    final class ActionMenuButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equals(startGame.getActionCommand())) {
                if (activePanel == null) {
                    game = new Game();
                    System.out.println(game.currentMap.characters.get(0));
                    activePanel = new PlayPanel(game.currentMap);
                    frame.setVisible(false);
                }
            }
        }
    }
    final class comboBoxListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String s =comboBox.getSelectedItem().toString();
            switch (s){
                case "3":
                    jPanel4.setVisible(false);
                    jPanel5.setVisible(false);
                    break;
                case "4":
                    jPanel4.setVisible(false);
                    jPanel5.setVisible(true);
                    break;
                case "5":
                    jPanel4.setVisible(true);
                    jPanel5.setVisible(true);
                    break;
                default:
                    break;
            }
        }
    }


}
