package hu.bme.team5;

public class DivingSuit extends Item {

    //Konstruktor
    public DivingSuit() {
        super();
    }

    //Ha szükség van rá akkor igazzal tér vissza
    @Override
    public boolean divingSuitNeeded() {
        System.out.println(">divingSuitNeeded()");
        System.out.println("<divingSuitNeeded()");
        return true;
    }
}
