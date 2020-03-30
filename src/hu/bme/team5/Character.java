package hu.bme.team5;

public class Character implements TurnBased, Controllable {
    protected Field currentField;
    protected int health;
    protected int work;
    protected boolean drowning;
    protected Inventory inventory;

    public Character() {
        currentField = new Field();
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
    public boolean move(Field nextField) {
        System.out.println("    >currentField.checkNeighbor(nextField)");
        boolean b1 = currentField.checkNeighbor(nextField);
        setWork(5);
        if (b1 && work > 0){
            setWork(work-1);
            System.out.println("        >currentField.removeCharacter(this)");
            currentField.removeCharacter(this);
            System.out.println("        <currentField.removeCharacter(this)");
            System.out.println("        >currentField.stepOn(this)");
            currentField.stepOn(this);
            System.out.println("        <currentField.stepOn(this)");
            System.out.println("        >setCurrentField(nextField)");
            setCurrentField(nextField);
            System.out.println("        <setCurrentField(nextField)");
        }
        System.out.println("    <currentField.checkNeighbor(nextField)");
        return b1;
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

    void setWork(int i){
        work = i;
    }

    void setCurrentField(Field f){
        currentField = f;
    }

}
