package hu.bme.team5;

public class Food extends Item {

    //Konstruktor
    public Food() {
        super();
    }

    //Ha szükség van rá akkor igazzal tér vissza
    @Override
    public boolean foodNeeded() {
        return true;
    }
}
