package hu.bme.team5;

import static hu.bme.team5.Menu.game;

public class Stable extends Iceberg {
    public Stable() {
        super();
        capacity=game.currentMap.characters.size()+1;
    }

    // Karakter rálép egy mezőre
    @Override
    public void stepOn(Movable m) {
        setMovable(m);
    }
}
