package hu.bme.team5;

public class DivingSuit extends Item {

    //Konstruktor
    public DivingSuit() {
        name = "diving suit";
    }

    //Ha szükség van rá akkor igazzal tér vissza
    @Override
    public boolean divingSuitNeeded() {
        return true;
    }
}
