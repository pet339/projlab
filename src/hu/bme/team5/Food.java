package hu.bme.team5;

public class Food extends Item {
    public Food() {
        super();
    }

    @Override
    public boolean foodNeeded() {
        return true;
    }
}
