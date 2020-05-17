package hu.bme.team5;

public class FragileShovel extends Shovel {
    FragileShovel(){
        name = "fragile shovel";
    }

    //Felüldefiniálja a Shovel függvényét, True-val tér vissza és növeli a számlálót
    @Override
    public boolean shovelNeeded(){
        counter++;
        return true;
    }

    @Override
    public String draw() {
        return "src/img/pix_broken.png";
    }
}
