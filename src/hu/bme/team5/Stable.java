package hu.bme.team5;

import static hu.bme.team5.MenuView.game;

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
}
