package hu.bme.team5;

import javax.swing.*;
import java.awt.*;

public class HexagonMapPanel extends JPanel {
    public HexagonMapPanel(){
        setPreferredSize(new Dimension(200, 200));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int r = 40;
        g.setColor(Color.BLUE);
        g.drawPolygon(createPolygon(240,300,r));
        g.setColor(Color.RED);
        g.drawPolygon(createPolygon(240 + 2*r- 10,260,r));
        g.setColor(Color.ORANGE);
        g.drawPolygon(createPolygon(240 + 4*r- 20,300,r));
        g.setColor(Color.pink);
        g.drawPolygon(createPolygon(240 + 2*r- 10,340,r));

    }
    public Polygon createPolygon(int x, int y, int r){
        Polygon p = new Polygon();
        for (int i = 0; i < 6; i++)
            p.addPoint((int) (x + r * Math.cos(i * 2 * Math.PI / 6)),
                    (int) (y + r * Math.sin(i * 2 * Math.PI / 6)));
        return p;
    }
}