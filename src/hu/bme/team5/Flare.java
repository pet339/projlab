package hu.bme.team5;

public class Flare extends Item {

    //Konstruktor
    public Flare() {
        super();
    }

    //Ha szükség van rá akkor igazzal tér vissza
    @Override
    public boolean winItemNeeded() {
        return true;
    }
}
