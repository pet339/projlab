package hu.bme.team5;

public class Flare extends Item {
    public Flare() {
        name = "flare";
    }

    @Override
    public boolean winItemNeeded() {
        return true;
    }

    @Override
    public String draw() {
        return "src/img/pix_flare.png";
    }
}
