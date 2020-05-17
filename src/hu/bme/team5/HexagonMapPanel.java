package hu.bme.team5;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HexagonMapPanel extends JPanel {
    //ArrayList<HexaField> hexafields = new ArrayList<HexaField>();
    Map m;
    ArrayList<ArrayList<Field>> fields;

    public HexagonMapPanel(Map m){
        setPreferredSize(new Dimension(200, 200));
        
        this.m = m ;
        fields = m.FullInitTest();
        MapDrawInit();
    }

    public void benjiPaint(Graphics g){

        
        int rowshift = 0;
        int shift2 = 0;
        int r = 28;
        System.out.println(fields.size());
        for(int i = 0 ; i < fields.size(); i++){
            
            System.out.println(fields.get(i).size());
            shift2 = r;
            for(int j = 0 ; j < fields.get(i).size(); j++){
                if(fields.get(i).get(j).characters.size()!=0)
                    g.setColor(Color.RED);
                

                g.drawPolygon(createPolygon(40+i*45+rowshift+shift2,20+j*45+rowshift+shift2,r));
                shift2+=r;
                g.setColor(Color.BLACK);
            }
            rowshift += 20;
            shift2 = 0;
        }
    }


    
    public Polygon createPolygon(int x, int y, int r){
        Polygon p = new Polygon();
        for (int i = 0; i < 6; i++)
            p.addPoint((int) (x + r * Math.cos(i * 2 * Math.PI / 6)),
                    (int) (y + r * Math.sin(i * 2 * Math.PI / 6)));
        return p;
    }

    public void MapDrawInit() {
        int r = 52;
        int shift = -180;
        m.fields.get(0).setPolygon(createPolygon(240 + shift,300 - 2* r,r));
        m.fields.get(1).setPolygon(createPolygon(240 + shift,300,r));


        m.fields.get(2).setPolygon(createPolygon(240 + shift + 2*r- r/4,300 - 3*r ,r));
        m.fields.get(3).setPolygon(createPolygon(240 + shift + 2*r- r/4,300-r,r));
        m.fields.get(4).setPolygon(createPolygon(240 + shift + 2*r- r/4,300+r,r));


        m.fields.get(5).setPolygon(createPolygon(240 + shift + 4*r- r/2,300 - 4*r ,r));
        m.fields.get(6).setPolygon(createPolygon(240 + shift + 4*r- r/2,300 - 2*r ,r));
        m.fields.get(7).setPolygon(createPolygon(240 + shift + 4*r- r/2,300,r));
        m.fields.get(8).setPolygon(createPolygon(240 + shift + 4*r- r/2,300 + 2*r,r));


        m.fields.get(9).setPolygon(createPolygon(240 + shift + 6*r- r/4 *3,300 - 3*r ,r));
        m.fields.get(10).setPolygon(createPolygon(240 + shift + 6*r- r/4 *3,300-r,r));
        m.fields.get(11).setPolygon(createPolygon(240 + shift + 6*r- r/4 *3,300+r,r));
        m.fields.get(12).setPolygon(createPolygon(240 + shift + 6*r- r/4 *3,300 + 3*r ,r));


        m.fields.get(13).setPolygon(createPolygon(240 + shift + 8*r- r,300 - 4*r ,r));
        m.fields.get(14).setPolygon(createPolygon(240 + shift + 8*r- r,300 - 2*r ,r));
        m.fields.get(15).setPolygon(createPolygon(240 + shift + 8*r- r,300,r));

        
        m.fields.get(16).setPolygon(createPolygon(240 + shift + 10*r- r/4 *5,300 - 3*r ,r));
        m.fields.get(17).setPolygon(createPolygon(240 + shift + 10*r- r/4 *5,300 - 1*r ,r));
        m.fields.get(18).setPolygon(createPolygon(240 + shift + 10*r- r/4 *5,300 + r ,r));
        
    }

    public void drawmap(Graphics g) {
        for(Field f : m.fields){
            f.DrawField(g);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
       drawmap(g);
    }

    public void akosdraw(Graphics g){
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
}