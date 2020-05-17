package hu.bme.team5;

public class Tent extends Item {

    Tent(){
        name = "tent";
    }
    //Felüldefiniálja az Item függvényét, true-val tér vissza
    @Override
    public boolean tentNeeded(){
        return true;
    }

    @Override
    public String draw() {
        return "src/img/pix_tent.png";
    }
}
