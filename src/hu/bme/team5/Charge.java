package hu.bme.team5;

public class Charge extends Item {

    //Konstruktor
    public Charge() {
        super();
    }

    //Ha szükség van rá akkor igazzal tér vissza
    @Override
    public boolean winItemNeeded() {
        return true;
    }
}
