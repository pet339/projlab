package hu.bme.team5;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HexagonMapPanel extends JPanel {
    ArrayList<HexaField> hexafields = new ArrayList<HexaField>();

    public HexagonMapPanel(Map m){
        setPreferredSize(new Dimension(200, 200));

        

        
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int r = 52;
        
        int shift = -180;

        // Az első oszlop
        g.setColor(Color.RED);

        g.drawPolygon(createPolygon(240 + shift,300 - 2* r,r));
        g.drawPolygon(createPolygon(240 + shift,300,r));

        // A második oszlop
        g.setColor(Color.BLUE);

        g.drawPolygon(createPolygon(240 + shift + 2*r- r/4,300 - 3*r ,r));
        g.drawPolygon(createPolygon(240 + shift + 2*r- r/4,300-r,r));
        g.drawPolygon(createPolygon(240 + shift + 2*r- r/4,300+r,r));

        //A harmadik oszlop
        g.setColor(Color.ORANGE);

        g.drawPolygon(createPolygon(240 + shift + 4*r- r/2,300 - 4*r ,r));
        g.drawPolygon(createPolygon(240 + shift + 4*r- r/2,300 - 2*r ,r));
        g.drawPolygon(createPolygon(240 + shift + 4*r- r/2,300,r));
        g.drawPolygon(createPolygon(240 + shift + 4*r- r/2,300 + 2*r,r));

        // A negyedik oszlop
        g.setColor(Color.GREEN);

        g.drawPolygon(createPolygon(240 + shift + 6*r- r/4 *3,300 - 3*r ,r));
        g.drawPolygon(createPolygon(240 + shift + 6*r- r/4 *3,300-r,r));
        g.drawPolygon(createPolygon(240 + shift + 6*r- r/4 *3,300+r,r));
        g.drawPolygon(createPolygon(240 + shift + 6*r- r/4 *3,300 + 3*r ,r));


        // Az ötödik oszlop

        g.setColor(Color.MAGENTA);
        g.drawPolygon(createPolygon(240 + shift + 8*r- r,300 - 4*r ,r));
        g.drawPolygon(createPolygon(240 + shift + 8*r- r,300 - 2*r ,r));
        g.drawPolygon(createPolygon(240 + shift + 8*r- r,300,r));

        //A 6. oszlop
        g.setColor(Color.RED);
        g.drawPolygon(createPolygon(240 + shift + 10*r- r/4 *5,300 - 3*r ,r));
        g.drawPolygon(createPolygon(240 + shift + 10*r- r/4 *5,300 - 1*r ,r));
        g.drawPolygon(createPolygon(240 + shift + 10*r- r/4 *5,300 + r ,r));
    }
    public Polygon createPolygon(int x, int y, int r){
        Polygon p = new Polygon();
        for (int i = 0; i < 6; i++)
            p.addPoint((int) (x + r * Math.cos(i * 2 * Math.PI / 6)),
                    (int) (y + r * Math.sin(i * 2 * Math.PI / 6)));
        return p;
    }
}