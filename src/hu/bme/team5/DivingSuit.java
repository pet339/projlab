package hu.bme.team5;

public class DivingSuit extends Item {
    public DivingSuit() {
        super();
    }

    @Override
    public boolean divingSuitNeeded() {
        System.out.println(">divingSuitNeeded()");
        System.out.println("<divingSuitNeeded()");
        return true;
    }
}
