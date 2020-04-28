package hu.bme.team5;

public class Shovel extends Item {
    public Shovel() {
        name = "shovel";
    }
    //felüldefinálja az item függvényét, true-val tér vissza
    @Override
    public boolean shovelNeeded() {
        return true;
    }

    public int getCounter(){
        return counter;
    }
}
