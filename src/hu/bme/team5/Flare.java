package hu.bme.team5;

public class Flare extends Item {
    public Flare() {
        name = "flare";
    }

    @Override
    public boolean winItemNeeded() {
        return true;
    }
}
