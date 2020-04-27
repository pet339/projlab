package hu.bme.team5;

public class Tent extends Item {

    //Felüldefiniálja az Item függvényét, true-val tér vissza
    @Override
    public boolean tentNeeded(){
        return true;
    }
}
