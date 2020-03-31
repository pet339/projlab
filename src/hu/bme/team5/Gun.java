package hu.bme.team5;

public class Gun extends Item {

    //Konstruktor
    public Gun() {
        super();
    }

    //Ha szükség van rá akkor igazzal tér vissza
    @Override
    public boolean winItemNeeded() {
        return true;
    }
}
