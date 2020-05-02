package hu.bme.team5;

import javax.swing.*;

public class BackGround extends JFrame {
    JPanel jp = new JPanel();
    JButton start = new JButton();
    JButton load = new JButton();
    JButton save = new JButton();
    JButton exit = new JButton();

    public BackGround() {
        initWindow();
    }

    void initWindow() {
        JFrame frame = new JFrame("BackGround");

        //start.addActionListener(new BackGround.ActionMenuButtonListener());
        //load.addActionListener(new BackGround.ActionMenuButtonListener());
        //save.addActionListener(new BackGround.ActionMenuButtonListener());
        //exit.addActionListener(new BackGround.ActionMenuButtonListener());


        start.setText("Start");
        load.setText("Load");
        save.setText("Save");
        exit.setText("Exit");


        jp.add(start);
        jp.add(load);
        jp.add(save);
        jp.add(exit);

        start.setAlignmentX(CENTER_ALIGNMENT);
        load.setAlignmentX(CENTER_ALIGNMENT);
        save.setAlignmentX(CENTER_ALIGNMENT);
        exit.setAlignmentX(CENTER_ALIGNMENT);

        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));


        this.add(jp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /*
    final class ActionMenuButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals(start.getActionCommand()))
                ;

            if(e.getActionCommand().equals(load.getActionCommand()))
                ;

            if(e.getActionCommand().equals(save.getActionCommand()))
                ;

            if(e.getActionCommand().equals(exit.getActionCommand()))
                ;



    }
     */


}
