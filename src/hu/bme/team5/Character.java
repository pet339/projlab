package hu.bme.team5;

public abstract class Character extends Movable implements TurnBased, Controllable {
    
    protected Field currentField; //A field amin a karakter áll
    protected int health; //A karakter életét tartalmazó integer
    protected int work; //A karakter munkáját tartalmazó integer 
    protected boolean drowning; //A karakter éppen foldiklik e
    protected Inventory inventory; //A karakter inventoryja

    //Konstruktor
    public Character() {
        currentField = new Stable();
        inventory = new Inventory();
    }

    //Két azonos mezőn álló karakter itemeket cserél egymással, a belső működése az inventory felelőssége
    public void trade(Character c, Item i1) {
        System.out.println(">trade(c)");
        Field f1 = c.getCurrentField();
        //Megnézzük hogy azonos mezőn állnak e
        if (currentField != f1){
            System.out.println("Nem azonos mezon allnak");
        }
        //Innentől a két inventory tradel egymással
        else{
            Inventory nv = c.getInventory();
            inventory.tradeWithInventory(nv, i1);
        }

        System.out.println("<trade(c)");
    }

    //Ezek működése a későbbiekben lesz megvalósítva
    @Override
    public void endTurn() {

    }
    @Override
    public void startTurn() {

    }

    //Karakter lép, paraméter az a field amire lépni akarunk
    public boolean move(Field nextField) {
        System.out.println(">move(nextField)");
        //Megnézzök hogy szomszédos e
        boolean b1 = currentField.checkNeighbor(nextField);
        if(work <= 0){
            //Megnézzük hogy van e elég munka
            System.out.println("    Nincs eleg munkaegyseg a lepeshez");
            return false;
        }

        if(!b1){
            System.out.println("    Nem szomszedos a mezo");
            return false;
        }

        if (currentField.polarBear){
            //                  <-------- ENDGAME
        }

        //Elveszünk 1 munkát a fieldek elvégzik a karakterek kezelését.
        setWork(work-1);
        currentField.removeMovable(this);
        currentField.stepOn(this);
        setCurrentField(nextField);

        System.out.println("<move(nextField)");
        return true;
    }

    //karakter havat takarít
    @Override
    public boolean shovelSnow() {
        System.out.println(">Character.shovelSnow()");

        //Munka ellenőrzése
        if(work==0){
            System.out.println("\t-Nincs munka, nem lehet asni.");
            System.out.println("<Character.shovelSnow()");
            return false;
        }

        //Hó nagyságának ellenőrzése
        if(currentField.snowSize==0){
            System.out.println("\t-Nincs ho, nincs mit asni.");
            System.out.println("<Character.shovelSnow()");
            return false;
        }

        System.out.print("\t-Ho asas elott: " + currentField.snowSize + "\n");

        //Megnézzük hogy van e ásónk , belső működése az inventory felelőssége
        if(inventory.shovelSnowUsed()){
            currentField.setSnowSize(Math.max(currentField.snowSize-2, 0));
        }
        else currentField.setSnowSize(currentField.snowSize-1);

        System.out.print("\t-Ho asas utan: " + currentField.snowSize + "\n");

        System.out.println("<Character.shovelSnow()");
        return true;
    }

    //Karakter kiás egy itemet
    public boolean digItem(){
        System.out.println(">Character.digItem()");

        //Hó nagyságának ellenőrzése
        if(currentField.snowSize!=0){
            System.out.println("\t-Itt ho van, nem lehet targyat kiasni.");
            System.out.println("<Character.digItem()");
            return false;
        }

        //Munka ellenőrzése
        if(work==0){
            System.out.println("\t-Nincs munka, nem lehet targyat kiasni.");
            System.out.println("<Character.digItem()");
            return false;
        }

        //Van e a táblában befagyott item
        if(currentField.getFrozenItem()==null){
            System.out.println("\t-Nincs targy, nincs mit kiasni.");
            System.out.println("<Character.digItem()");
            return false;
        }

        //Az inventoryba rakjuk az itemet
        inventory.addItem(currentField.getFrozenItem());
        currentField.setFrozenItem(null);

        System.out.println("<Character.digItem()");
        return true;
    }

    //Karakter összerakja a jelzőpisztolyt
    @Override
    public boolean assemble() {
        System.out.println(">assemble()");

        //Munka ellenőrzése
        if(work > 0){
            setWork(work-1);

            //inventory ellenőrzi hogy meg vannak e a tárgyak
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

    
    //Karakter kiment egy paraméterként megadott karaktert
    @Override
    public boolean saveAlly(Character ally) {
        System.out.println(">saveAlly(ally)");

        //Ellenőrizzük hogy mellettünk lévő fielden van e valamint ,hogy fuldoklik e
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

    //karakter fuldoklik
    @Override
    public boolean drown() {

        //Az inventory kideríti hogy van e nálla búvárruha
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

    //Karakter eszik
    @Override
    public boolean eat() {
        //Nem növeljük az életet ha elérte a maximum értéket vagy ha nincs élelm a karakternél
        if(health==256 || !inventory.eatUsed()){
            return false;
        }
        health++;
        inventory.removeFood();
        return true;
    }

    public boolean buildTent(){
        if (work <= 0){
            System.out.println("Nincs eleg munka!");
            return false;
        }
        boolean has = inventory.tentUsed();
        if (has){
            System.out.println("Sator megepitve!");
            currentField.tent = true;
            return true;
        }
        else{
            System.out.println("Nincs satrad!");
        }
        return false;
    }

    //Getter/Setterek
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

    
    int explore(Field f) {return -1;}
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
