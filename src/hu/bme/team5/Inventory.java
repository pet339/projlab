package hu.bme.team5;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;

    public Inventory() {
    }

    public boolean shovelSnowUsed() {
        System.out.println(">shovelSnowUsed");
        for(Item i : items){
            if(i.shovelNeeded())
                return true;
        }
        System.out.println("<shovelSnowUsed");
        return false;
    }

    public boolean assembleUsed() {
        System.out.println(">assembleUsed");
        for(Item i : items){
            if(i.winItemNeeded())
                return true;
        }
        System.out.println("<assembleUsed");
        return false;
    }

    public boolean drownUsed() {
        System.out.println(">drownUsed");
        for(Item i : items){
            if(i.divingSuitNeeded())
                return true;
        }
        System.out.println("<drownUsed");
        return false;
    }

    public boolean eatUsed() {
        System.out.println(">eatUsed");
        for(Item i : items){
            if(i.foodNeeded())
                return true;
        }
        System.out.println("<eatUsed");
        return false;
    }

    public boolean saveAllyUsed() {
        System.out.println(">saveAllyUsed");
        for(Item i : items){
            if(i.ropeNeeded())
                return true;
        }
        System.out.println("<saveAllyUsed");
        return false;
    }

    public void addItem(Item i) {
        System.out.println(">addItem");
        items.add(i);
        System.out.println("<addItem");
    }

    public void tradeWithInventory(Inventory i) {
        
    }

}
