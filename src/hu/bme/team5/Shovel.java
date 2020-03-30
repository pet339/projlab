package hu.bme.team5;

public class Shovel extends Item {
    public Shovel() {
        super();
    }

    @Override
    public boolean shovelNeeded() {
        return true;
    }
}
