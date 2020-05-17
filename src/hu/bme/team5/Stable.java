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

        g.setColor(new Color(0, 105, 148));
        g.fillPolygon(p);
        
    }
}
