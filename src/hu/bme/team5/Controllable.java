package hu.bme.team5;

public interface Controllable {
    public boolean move(Field f);

    public boolean shovelSnow();

    public boolean assemble();

    public boolean saveAlly(Character ally);

    public boolean drown();

    public boolean eat();
}
