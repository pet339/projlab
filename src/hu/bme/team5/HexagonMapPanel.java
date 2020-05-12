package hu.bme.team5;

import javax.swing.*;
import java.awt.*;

public class HexagonMapPanel extends JPanel {
    public HexagonMapPanel(){
        setPreferredSize(new Dimension(200, 200));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawPolygon(createPolygon(300,300,30));
        g.drawPolygon(createPolygon(360,300,30));
        g.drawPolygon(createPolygon(420,300,30));

    }
    public Polygon createPolygon(int x, int y, int r){
        Polygon p = new Polygon();
        for (int i = 0; i < 6; i++)
            p.addPoint((int) (x + r * Math.cos(i * 2 * Math.PI / 6)),
                    (int) (y + r * Math.sin(i * 2 * Math.PI / 6)));
        return p;
    }
}