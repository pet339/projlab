package hu.bme.team5;

public class Gun extends Item {
    public Gun() {
        super();
    }

    @Override
    public boolean winItemNeeded() {
        return true;
    }
}
