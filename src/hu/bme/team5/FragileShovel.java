package hu.bme.team5;

public class FragileShovel extends Shovel {
    //Felüldefiniálja a Shovel függvényét, True-val tér vissza és növeli a számlálót
    @Override
    public boolean shovelNeeded(){
        counter++;
        return true;
    }
}
