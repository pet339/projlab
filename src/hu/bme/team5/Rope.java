package hu.bme.team5;

public class Rope extends Item {
    int counter = 0;

    public Rope() {
        name = "rope";
    }


    //felüldefinálja az item függvényét, true-val tér vissza
    @Override
    public boolean ropeNeeded() {
        return true;
    }
    // Push2


    @Override
    public String draw() {
        return "src/img/pix_rope.png";
    }
}
