package hu.bme.team5;

public abstract class Character implements TurnBased, Controllable {
    protected Field currentField;
    protected int health;
    protected int work;
    protected boolean drowning;
    protected Inventory inventory;

    public Character() {
        currentField = new Stable();
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
        System.out.println(">move(nextField)");
        boolean b1 = currentField.checkNeighbor(nextField);

        setWork(5);
        if (b1 && work > 0){
            setWork(work-1);
            currentField.removeCharacter(this);
            currentField.stepOn(this);
            setCurrentField(nextField);
        }

        System.out.println("<move(nextField)");
        return b1;
    }

    @Override
    public boolean shovelSnow() {
        System.out.println(">Character.shovelSnow()");

        if(work==0){
            System.out.println("-Nincs munka, nem lehet asni.");
            System.out.println("<Character.shovelSnow()");
            return false;
        }
        if(currentField.snowSize==0){
            System.out.println("-Nincs ho, nincs mit asni.");
            System.out.println("<Character.shovelSnow()");
            return false;
        }

        System.out.print("-Ho asas elott: " + currentField.snowSize + "\n");

        if(inventory.shovelSnowUsed()){
            currentField.setSnowSize(Math.max(currentField.snowSize-2, 0));
        }
        else currentField.setSnowSize(currentField.snowSize-1);

        System.out.print("-Ho asas utan: " + currentField.snowSize + "\n");

        System.out.println("<Character.shovelSnow()");
        return true;
    }

    public boolean digItem(){
        System.out.println(">Character.digItem()");
        if(currentField.snowSize!=0){
            System.out.println("-Itt ho van, nem lehet targyat kiasni.");
            System.out.println("<Character.digItem()");
            return false;
        }
        if(work==0){
            System.out.println("-Nincs munka, nem lehet targyat kiasni.");
            System.out.println("<Character.digItem()");
            return false;
        }
        if(currentField.getFrozenItem()==null){
            System.out.println("-Nincs targy, nincs mit kiasni.");
            System.out.println("<Character.digItem()");
            return false;
        }
        inventory.addItem(currentField.getFrozenItem());
        currentField.setFrozenItem(null);

        System.out.println("<Character.digItem()");
        return true;
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
        System.out.println(">setCurrentField()");
        currentField = nextField;
        System.out.println("<setCurrentField()");
    }
    
    
    boolean explore() {return false;}
    boolean buildIgloo() {return false;}

    void setDrowning(boolean d){
        System.out.println(">setDrowning(d)");
        drowning = d;
        System.out.println("<setDrowning(d)");
    }


}
