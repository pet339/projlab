package hu.bme.team5;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class BackGround extends JFrame {
    JFrame frame = new JFrame("Menü") {
        private Image backgroundImage;

        {
            try {
                backgroundImage = ImageIO.read(new File("backImage.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(backgroundImage, 0, 0, this);
        }
    };
    JPanel jp = new JPanel();
    JButton start = new JButton();
    JButton load = new JButton();
    JButton save = new JButton();
    JButton exit = new JButton();

    public BackGround() {
        try {
            initWindow();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void initWindow() throws IOException {

        start.addActionListener(new BackGround.ActionMenuButtonListener());
        load.addActionListener(new BackGround.ActionMenuButtonListener());
        save.addActionListener(new BackGround.ActionMenuButtonListener());
        exit.addActionListener(new BackGround.ActionMenuButtonListener());


        start.setText("Start");
        load.setText("Load");
        save.setText("Save");
        exit.setText("Exit");

        start.add(Box.createRigidArea(new Dimension(50, 10)));
        load.add(Box.createRigidArea(new Dimension(50, 10)));
        save.add(Box.createRigidArea(new Dimension(50, 10)));
        exit.add(Box.createRigidArea(new Dimension(50, 10)));


        jp.add(Box.createRigidArea(new Dimension(50, 100)));
        jp.add(start);
        jp.add(Box.createRigidArea(new Dimension(50, 30)));
        jp.add(load);
        jp.add(Box.createRigidArea(new Dimension(50, 30)));
        jp.add(save);
        jp.add(Box.createRigidArea(new Dimension(50, 30)));
        jp.add(exit);

        start.setAlignmentX(CENTER_ALIGNMENT);
        load.setAlignmentX(CENTER_ALIGNMENT);
        save.setAlignmentX(CENTER_ALIGNMENT);
        exit.setAlignmentX(CENTER_ALIGNMENT);

        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        frame.add(jp, BorderLayout.CENTER);
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    final class ActionMenuButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals(start.getActionCommand())) {
                PlayPanel playPanel = new PlayPanel();
            }

            if (e.getActionCommand().equals(load.getActionCommand()))
                ;

            if (e.getActionCommand().equals(save.getActionCommand()))
                ;

            if (e.getActionCommand().equals(exit.getActionCommand()))
                System.exit(0);


        }


    }
}
