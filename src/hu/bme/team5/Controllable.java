package hu.bme.team5;

public interface Controllable {

    //Mozgás
    public boolean move(Field f);

    //Hóásás
    public boolean shovelSnow();

    //Jelzőpisztoly összeszerelés
    public boolean assemble();

    //Csapattárs kihúzása lyukból
    public boolean saveAlly(Character ally);

    //Fuldoklás
    public boolean drown();

    //Evés
    public boolean eat();
}
