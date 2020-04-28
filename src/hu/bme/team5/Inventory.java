package hu.bme.team5;

import java.util.ArrayList;

public class Inventory {
    ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<Item>();
    }

    public boolean shovelSnowUsed() {
        for(Item i : items){
            if(i.shovelNeeded()) {
                // Ha még nem használták 3-szor true-val tér vissza
                if (i.counter < 4){
                    return true;
                }

                // Ha használták, akkor törli az itemet
                else{
                    items.remove(i);
                }
            }
        }
        return false;
    }

    public boolean assembleUsed() {
        int parts = 0;
        for(Item i : items){
            if(i.winItemNeeded())
                parts++;
        }
        if(parts == 3){
            return true;
        }
        return false;
    }

    public boolean drownUsed() {
        for(Item i : items){
            if(i.divingSuitNeeded()) {
                return true;
            }
        }
        return false;
    }

    public boolean eatUsed() {
        for(Item i : items){
            if(i.foodNeeded()) {
                return true;
            }
        }
        return false;
    }

    public boolean saveAllyUsed() {
        for(Item i : items){
            if(i.ropeNeeded()) {
                return true;
            }
        }
        return false;
    }

    public void addItem(Item i) {
        items.add(i);
    }

    public void tradeWithInventory(Inventory nv, Item i1) {
        nv.addItem(i1);
        items.remove(i1);
    }

    public void removeFood(){
        for(Item i : items){
            if(i.foodNeeded()) {
                items.remove(i);
                break;
            }
        }
    }
    public boolean tentUsed(){
        for (Item i : items){
            if (i.tentNeeded()){
                System.out.println("Sator felallitva");
                items.remove(i);
                return true;
            }
        }
        return false;
    }

}
