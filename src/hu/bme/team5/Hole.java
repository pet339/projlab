package hu.bme.team5;

public class Hole extends Field {
    public Hole() {
        super();
        capacity=0;
    }

    @Override
    public void stepOn(Character c) {
        setCharacter(c);
        setSnowSize(0);
        characters.get(characters.size()-1).drown();
    }

    @Override
    public Item getFrozenItem() {
        return null;
    }

    @Override
    public void setFrozenItem(Item i) {

    }
}
