package hu.bme.team5;

public class Rope extends Item {
    public Rope() {
        super();
    }

    //felüldefinálja az item függvényét, true-val tér vissza
    @Override
    public boolean ropeNeeded() {
        return true;
    }
    // Push Test
}
