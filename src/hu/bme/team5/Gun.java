package hu.bme.team5;

public class Gun extends Item {
    public Gun() {
        super();
    }

    //felüldefinálja az item függvényét, true-val tér vissza
    @Override
    public boolean winItemNeeded() {
        return true;
    }
}
