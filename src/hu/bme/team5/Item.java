package hu.bme.team5;

public abstract class Item {
    private String description;

    public Item() {
    }

    public boolean shovelNeeded() {
        return false;
    }

    public boolean foodNeeded() {
        return false;
    }

    public boolean ropeNeeded() {
        return false;
    }

    public boolean divingSuitNeeded() {
        return false;
    }

    public boolean winItemNeeded() {
        return false;
    }
}
