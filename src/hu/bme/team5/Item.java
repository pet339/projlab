package hu.bme.team5;

public abstract class Item {
    private String description;

    public Item() {
    }

    // asohasznalat, Overrideolva lesz, az shovel-nel true-val ter vissza
    public boolean shovelNeeded() {
        return false;
    }

    // etelhaszmalat, Overrideolva lesz, az food-nal true-val ter vissza
    public boolean foodNeeded() {
        return false;
    }

    // Kötelhasznalat, Overrideolva lesz, az rope-nal true-val ter vissza
    public boolean ropeNeeded() {
        return false;
    }

    // Búvarruha hasznalat, Overrideolva lesz, az divingSuit-nal true-val ter vissza
    public boolean divingSuitNeeded() {
        return false;
    }

    // Gyozelemhez szükseges itemek, Overrideolva lesz, Flare, Charge, Gun-nal true-val ter vissza
    public boolean winItemNeeded() {
        return false;
    }
}
