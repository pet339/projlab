package hu.bme.team5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuView extends JFrame {

    private PlayPanel activePanel = null;

    private JFrame frame = new JFrame("Menu");
    private JPanel jp = new JPanel();
    private JButton start = new JButton();
    private JButton exit = new JButton();

    public MenuView() {
        try {
            initWindow();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void initWindow() throws IOException {

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
            Map m = new Map(new Game());
            m.init();
            if (e.getActionCommand().equals(start.getActionCommand())) {
                if (activePanel == null)
                    activePanel = new PlayPanel(m);
            }
            if (e.getActionCommand().equals(exit.getActionCommand()))
                System.exit(0);
        }


    }
}
