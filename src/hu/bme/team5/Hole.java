package hu.bme.team5;

public class Hole extends Field {
    public Hole() {
        super();
    }

    @Override
    public void stepOn(Character c) {
        setCharacter(c);
        setSnowSize(0);
        characters.get(characters.size()-1).drown();
    }

    @Override
    public Item getFrozenItem() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setFrozenItem(Item i) {
        // TODO Auto-generated method stub

    }
}
