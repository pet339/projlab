package hu.bme.team5;

import static hu.bme.team5.MenuView.game;
import java.awt.*;

public class Stable extends Iceberg {
    public Stable() {
        super();
        capacity=1000;
    }

    // Karakter rálép egy mezőre
    @Override
    public void stepOn(Character c) {
        setCharacter(c);
    }

    public void DrawField(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(4, 167, 52));
        
        g2.fillPolygon(p);
        if(snowSize!=0){
            g2.setColor(new Color(138,195,209));
            g2.fillPolygon(p);
        }
       
        
    }

    public void getExplored(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(4, 167, 52));
        
        g2.fillPolygon(p);
        if(snowSize!=0){
            g2.setColor(new Color(138,195,209));
            g2.setStroke(new BasicStroke(10));
            g2.drawPolygon(p);
        }
        
    }
}
