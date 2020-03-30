package hu.bme.team5;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<Item>();
    }

    public boolean shovelSnowUsed() {
        System.out.println(">Inventory.shovelSnowUsed");
        for(Item i : items){
            if(i.shovelNeeded()) {
                System.out.println("<Inventory.shovelSnowUsed");
                return true;
            }
        }
        System.out.println("<Inventory.shovelSnowUsed");
        return false;
    }

    public boolean assembleUsed() {
        int parts = 0;
        System.out.println(">Inventory.assembleUsed");
        for(Item i : items){
            if(i.winItemNeeded())
                parts++;
        }
        if(parts == 3){
        System.out.println("<Inventory.assembleUsed");
        return true;
        }
        System.out.println("<Inventory.assembleUsed");
        return false;
    }

    public boolean drownUsed() {
        System.out.println(">Inventory.drownUsed");
        for(Item i : items){
            if(i.divingSuitNeeded()) {
                System.out.println("<Inventory.drownUsed");
                return true;
            }
        }
        System.out.println("<Inventory.drownUsed");
        return false;
    }

    public boolean eatUsed() {
        System.out.println(">Inventory.eatUsed");
        for(Item i : items){
            if(i.foodNeeded()) {
                System.out.println("<Inventory.eatUsed");
                return true;
            }
        }
        System.out.println("<Inventory.eatUsed");
        return false;
    }

    public boolean saveAllyUsed() {
        System.out.println(">Inventory.saveAllyUsed");
        for(Item i : items){
            if(i.ropeNeeded()) {
                System.out.println("<Inventory.saveAllyUsed");
                return true;
            }
        }
        System.out.println("<Inventory.saveAllyUsed");
        return false;
    }

    public void addItem(Item i) {
        System.out.println(">Inventory.addItem");
        items.add(i);
        System.out.println("<Inventory.addItem");
    }

    public void tradeWithInventory(Inventory i) {

    }

    public void removeFood(){
        System.out.println(">Inventory.removeFood()");
        for(Item i : items){
            if(i.foodNeeded()) {
                System.out.println("<Inventory.removeFood()");
                items.remove(i);
                break;
            }
        }
    }

}
