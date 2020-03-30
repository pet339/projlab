package hu.bme.team5;

public abstract class Character implements TurnBased, Controllable {
    protected Field currentField;
    protected int health;
    protected int work;
    protected boolean drowning;
    protected Inventory inventory;

    public Character() {
        currentField = new Field();
        inventory = new Inventory();
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
        System.out.println(">character.move(nextField)");
        boolean b1 = currentField.checkNeighbor(nextField);

        setWork(5);
        if (b1 && work > 0){
            setWork(work-1);
            System.out.println(">currentField.removeCharacter(this)");
            currentField.removeCharacter(this);
            System.out.println("<currentField.removeCharacter(this)");
            System.out.println(">currentField.stepOn(this)");
            currentField.stepOn(this);
            System.out.println("<currentField.stepOn(this)");
            System.out.println(">setCurrentField(nextField)");
            setCurrentField(nextField);
            System.out.println("<setCurrentField(nextField)");
        }

        System.out.println("<character.move(nextField)");
        return b1;
    }

    @Override
    public boolean shovelSnow() {
        System.out.println(">Character.shovelSnow()");
        System.out.println("<Character.shovelSnow()");
        return false;
    }

    @Override
    public boolean assemble() {
        System.out.println(">Character.assemble()");
        System.out.println("<Character.assemble()");
        return false;
    }

    @Override
    public boolean saveAlly() {
        System.out.println(">Character.saveAlly()");
        System.out.println("<Character.saveAlly()");
        return false;
    }

    @Override
    public boolean drown() {
        System.out.println(">drown()");
        boolean b2 = inventory.drownUsed();
        if (!b2){
            setDrowning(true);
        }
        System.out.println("<drown()");
        return b2;
    }

    @Override
    public boolean eat() {
        return false;
    }

    void setWork(int number){
        System.out.println(">setWork(number)");
        work = number;
        System.out.println("<setWork(number)");
    }

    
    void setCurrentField(Field nextField){
        System.out.println(">setCurrentField(nextField)");
        currentField = nextField;
        System.out.println("<setCurrentField(nextField)");
    }
    
    
    boolean explore() {return false;}
    boolean buildIgloo() {return false;}

    void setDrowning(boolean d){
        System.out.println(">setDrowning(d)");
        drowning = d;
        System.out.println("<setDrowning(d)");
    }
}
