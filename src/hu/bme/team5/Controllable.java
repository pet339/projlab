package hu.bme.team5;

public interface Controllable {


    //Hóásás
    public boolean shovelSnow();

    //Jelzőpisztoly összeszerelés
    public boolean assemble();

    //Csapattárs kihúzása lyukból
    public boolean saveAlly(Character ally);

    //Evés
    public boolean eat();

    public boolean drown();
}
