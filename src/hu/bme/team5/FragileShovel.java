package hu.bme.team5;

public class FragileShovel extends Shovel {
    @Override
    public boolean shovelNeeded(){
        counter++;
        return true;
    }
}
