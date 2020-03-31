package hu.bme.team5;

public abstract class Item {
    private String description;

    public Item() {
    }
    // Ásóhasználat, Overrideolva lesz, az shovel-nél true-val tér vissza
    public boolean shovelNeeded() {
        return false;
    }
    // Ételhaszmálat, Overrideolva lesz, az food-nál true-val tér vissza
    public boolean foodNeeded() {
        return false;
    }
    // Kötélhasználat, Overrideolva lesz, az rope-nál true-val tér vissza
    public boolean ropeNeeded() {
        return false;
    }
    // Búvárruha használat, Overrideolva lesz, az divingSuit-nál true-val tér vissza
    public boolean divingSuitNeeded() {
        return false;
    }
    // Győzelemhez szükséges itemek, Overrideolva lesz, Flare, Charge, Gun-nal true-val tér vissza
    public boolean winItemNeeded() {
        return false;
    }
}
