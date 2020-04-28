package hu.bme.team5;

public class Food extends Item {
    public Food() {
        name = "food";
    }

    @Override
    public boolean foodNeeded() {
        return true;
    }
}
