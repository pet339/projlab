package hu.bme.team5;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<Item>();
    }

    public boolean shovelSnowUsed() {
        System.out.println(">shovelSnowUsed()");
        for(Item i : items){
            if(i.shovelNeeded()) {
                // Ha még nem használták 3-szor true-val tér vissza
                if (i.counter < 4)
                {
                    System.out.println("<shovelSnowUsed()");
                    return true;
                }
                // Ha használták, akkor törli az itemet
                else{
                    items.remove(i);
                }
            }
        }
        System.out.println("<shovelSnowUsed()");
        return false;
    }

    public boolean assembleUsed() {
        int parts = 0;
        System.out.println(">assembleUsed()");
        for(Item i : items){
            if(i.winItemNeeded())
                parts++;
        }
        if(parts == 3){
        System.out.println("<assembleUsed()");
        return true;
        }
        System.out.println("<assembleUsed()");
        return false;
    }

    public boolean drownUsed() {
        System.out.println(">drownUsed()");
        for(Item i : items){
            if(i.divingSuitNeeded()) {
                System.out.println("<drownUsed()");
                return true;
            }
        }
        System.out.println("<drownUsed()");
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
        System.out.println(">saveAllyUsed()");
        for(Item i : items){
            if(i.ropeNeeded()) {
                System.out.println("<saveAllyUsed()");
                return true;
            }
        }
        System.out.println("<saveAllyUsed()");
        return false;
    }

    public void addItem(Item i) {
        System.out.println(">addItem()");
        items.add(i);
        System.out.println("<addItem()");
    }

    public void tradeWithInventory(Inventory nv, Item i1) {
        System.out.println(">tradeWithInventory(nv, i1)");
        nv.addItem(i1);
        items.remove(i1);
        System.out.println("<tradeWithInventory(nv, i1)");
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
