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
}
