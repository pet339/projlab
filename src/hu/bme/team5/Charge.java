package hu.bme.team5;

public class Charge extends Item {
    public Charge() {
        name = "charge";
    }

    @Override
    public boolean winItemNeeded() {
        return true;
    }
}
