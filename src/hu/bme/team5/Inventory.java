package hu.bme.team5;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public boolean shovelSnowUsed() {
        return false;
    }

    public boolean assembleUsed() {
        return false;
    }

    public boolean drownUsed() {
        System.out.println(">drownUsed()");
        System.out.println("<drownUsed()");
        return false;
    }

    public boolean eatUsed() {
        return false;
    }

    public boolean saveAllyUsed() {
        return false;
    }

    public void addItem(Item i) {
        System.out.println(">addItem(i)");
        System.out.println("<addItem(i)");
    }

    public void tradeWithInventory(Inventory i) {
    }

}
