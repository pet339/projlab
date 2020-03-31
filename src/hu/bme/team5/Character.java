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

    public void trade(Character c, Item i1) {
        System.out.println(">trade(c)");
        Field f1 = c.getCurrentField();
        if (currentField != f1){
            System.out.println("Nem azonos mezon allnak");
        }
        else{
            Inventory nv = c.getInventory();
            inventory.tradeWithInventory(nv, i1);
        }

        System.out.println("<trade(c)");
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
        if(work <= 0)
            System.out.println("    Nincs eleg munkaegyseg a lepeshez");
        if(!b1)
            System.out.println("    Nem szomszedos a mezo");
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
            System.out.println("\t-Nincs munka, nem lehet asni.");
            System.out.println("<Character.shovelSnow()");
            return false;
        }
        if(currentField.snowSize==0){
            System.out.println("\t-Nincs ho, nincs mit asni.");
            System.out.println("<Character.shovelSnow()");
            return false;
        }

        System.out.print("\t-Ho asas elott: " + currentField.snowSize + "\n");

        if(inventory.shovelSnowUsed()){
            currentField.setSnowSize(Math.max(currentField.snowSize-2, 0));
        }
        else currentField.setSnowSize(currentField.snowSize-1);

        System.out.print("\t-Ho asas utan: " + currentField.snowSize + "\n");

        System.out.println("<Character.shovelSnow()");
        return true;
    }

    public boolean digItem(){
        System.out.println(">Character.digItem()");
        if(currentField.snowSize!=0){
            System.out.println("\t-Itt ho van, nem lehet targyat kiasni.");
            System.out.println("<Character.digItem()");
            return false;
        }
        if(work==0){
            System.out.println("\t-Nincs munka, nem lehet targyat kiasni.");
            System.out.println("<Character.digItem()");
            return false;
        }
        if(currentField.getFrozenItem()==null){
            System.out.println("\t-Nincs targy, nincs mit kiasni.");
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
        System.out.println(">assemble()");
        if(work > 0){
            setWork(work-1);
            boolean b1 = inventory.assembleUsed();
            if(!b1)
                System.out.println("Hianyzik a jelzopisztoly resze");
            System.out.println("<assemble()");
        }
        else
            System.out.println("Nincs eleg munkaegyseg");
        System.out.println("<assemble()");
        return false;
    }

    @Override
    public boolean saveAlly(Character ally) {
        System.out.println(">saveAlly(ally)");
        if(work > 0){
            Field f1 = ally.getCurrentField();
            boolean b1 = currentField.checkNeighbor(f1);
            boolean b2 = ally.isDrowning();
            if(b1 && b2){
                setWork(work -1);
                ally.setDrowning(false);
                currentField.stepOn(ally);
                ally.setCurrentField(currentField);
            }else{
                System.out.println("Nem szomszedos mezon van a masik karakter vagy nem fulladozik (buvarruha vedi)");
                System.out.println("<saveAlly(ally)");
                return false;
            }
        }
        else{
            System.out.println("Nincs eleg munkaegyseg a menteshez");
            System.out.println("<saveAlly()");
            return false;
        }
        System.out.println("<saveAlly()");
        return true;
    }

    @Override
    public boolean drown() {
        System.out.println(">drown()");
        boolean b2 = inventory.drownUsed();
        if (!b2){
            System.out.println("Lyukba esett a karakter es megfullad");
            setDrowning(true);
        }
        else
            System.out.println("Buvarruha megvedi a karaktert a megfulladastol");
        System.out.println("<drown()");
        return b2;
    }

    @Override
    public boolean eat() {
        System.out.println(">Character.eat()");
        if(health==256){
            System.out.println("\t-Maximum elet, nem tud többet enni.");
            System.out.println("<Character.eat()");
            return false;
        }
        System.out.print("\t-Elet elotte: " + health + "\n");
        health++;
        inventory.removeFood();
        System.out.print("\t-Elet utana: " + health + "\n");
        System.out.println("<Character.eat()");
        return true;
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

    Field getCurrentField(){
        return currentField;
    }
    Inventory getInventory(){return inventory;}

    
    boolean explore(Field f) {return false;}
    boolean buildIgloo() {return false;}

    void setDrowning(boolean d){
        System.out.println(">setDrowning(d)");
        drowning = d;
        System.out.println("<setDrowning(d)");
    }

    boolean isDrowning(){
        System.out.println(">isDrowning()");
        System.out.println("<isDrowning()");
        return drowning;
    }

    void setHealth(int h){
        System.out.println(">Character.setHealth()");
        health=h;
        System.out.println("<Character.setHealth()");
    }

}
