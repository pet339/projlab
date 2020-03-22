package hu.bme.team5;

public class Character implements TurnBased, Controllable {
    protected Field currentField;
    protected int health;
    protected int work;
    protected boolean drowning;
    protected Inventory inventory;

    public Character() {
    }

    public void trade(Character c) {
    }

    @Override
    public void endTurn() {

    }

    @Override
    public void startTurn() {

    }

    @Override
    public boolean move(Field f) {
        return false;
    }

    @Override
    public boolean shovelSnow() {
        return false;
    }

    @Override
    public boolean assemble() {
        return false;
    }

    @Override
    public boolean saveAlly() {
        return false;
    }

    @Override
    public boolean drown() {
        return false;
    }

    @Override
    public boolean eat() {
        return false;
    }


}
