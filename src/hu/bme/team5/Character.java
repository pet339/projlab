package hu.bme.team5;

public abstract class Character implements TurnBased, Controllable {
    
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
    }

    //Ezek működése a későbbiekben lesz megvalósítva
    @Override
    public void endTurn() {
        if (health < 1 || isDrowning()){
            die();
        }



    }


    //Karakter lép, paraméter az a field amire lépni akarunk
    public boolean move(Field nextField) {
        //Megnézzök hogy szomszédos e
        boolean b1 = currentField.checkNeighbor(nextField);
        if(work <= 0){
            //Megnézzük hogy van e elég munka
            System.out.println("Nincs eleg munkaegyseg a lepeshez");
            return false;
        }

        if(!b1){
            System.out.println("Nem szomszedos a mezo");
            return false;
        }

        if (currentField.polarBear){;
            //                  <-------- ENDGAME
        }

        //Elveszünk 1 munkát, a fieldek elvégzik a karakterek kezelését.
        setWork(work-1);
        currentField.removeCharacter(this);
        currentField.stepOn(this);
        setCurrentField(nextField);

        return true;
    }

    //karakter havat takarít
    @Override
    public boolean shovelSnow() {
        //Munka ellenőrzése
        if(work==0){
            System.out.println("\t-Nincs eleg munka, nem lehet asni.");
            return false;
        }

        //Hó nagyságának ellenőrzése
        if(currentField.snowSize==0){
            System.out.println("\t-Nincs ho, nincs mit asni.");
            return false;
        }

        //Megnézzük hogy van e ásónk , belső működése az inventory felelőssége
        if(inventory.shovelSnowUsed()){
            currentField.setSnowSize(Math.max(currentField.snowSize-2, 0));
        }
        else currentField.setSnowSize(currentField.snowSize-1);
        return true;
    }

    //Karakter kiás egy itemet
    public boolean digItem(){
        //Hó nagyságának ellenőrzése
        if(currentField.snowSize!=0){
            System.out.println("\t-Itt ho van, nem lehet asni.");
            return false;
        }

        //Munka ellenőrzése
        if(work==0){
            System.out.println("\t-Nincs munka, nem lehet asni.");
            return false;
        }

        //Van e a táblában befagyott item
        if(currentField.getFrozenItem()==null){
            System.out.println("\t-Nincs targy, nincs mit kiasni.");
            return false;
        }

        //Az inventoryba rakjuk az itemet
        inventory.addItem(currentField.getFrozenItem());
        currentField.setFrozenItem(null);

        return true;
    }

    //Karakter összerakja a jelzőpisztolyt
    @Override
    public boolean assemble() {
        //Munka ellenőrzése
        if(work==0){
            System.out.println("Nincs eleg munka!");
            return false;
        }
        //Inventory ellenőrzi, hogy megvannak-e a tárgyak
        boolean b1 = inventory.assembleUsed();
        if(!b1){
            System.out.println("Hianyzik a jelzopisztoly valamelyik resze");
            return false;
        }
        else{
            currentField.GameEnded(true);
            return true;
        }
    }
        

    
    //Karakter kiment egy paraméterként megadott karaktert
    @Override
    public boolean saveAlly(Character ally) {
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
                return true;
            }else{
                System.out.println("Nem szomszedos mezon van a masik karakter vagy nem fulladozik (buvarruha vedi)");
                return false;
            }
        }
        System.out.println("Nincs eleg munkaegyseg a menteshez");
        return false;
    }

    //karakter fuldoklik
    @Override
    public boolean drown() {
        //Az inventory kideríti hogy van e nálla búvárruha
        boolean b2 = inventory.drownUsed();
        if (!b2){
            System.out.println("Lyukba esett a karakter es megfullad");
            setDrowning(true);
        }
        else System.out.println("Buvarruha megvedi a karaktert a megfulladastol");
        return b2;
    }

    //Karakter eszik
    @Override
    public boolean eat() {
        //Nem növeljük az életet, ha elérte a maximum értéket, vagy ha nincs élelem a karakternél
        if(health==256 || !inventory.eatUsed()){
            return false;
        }
        setHealth(health+1);
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
        work = number;
    }
    
    void setCurrentField(Field nextField){
        currentField = nextField;
    }

    Field getCurrentField(){
        return currentField;
    }
    Inventory getInventory(){
        return inventory;
    }
    
    int explore(Field f) {return -1;}
    boolean buildIgloo() {return false;}

    void setDrowning(boolean d){
        drowning = d;
    }

    boolean isDrowning(){
        return drowning;
    }

    void setHealth(int h){
        health=h;
    }

    public void die(){
        currentField.GameEnded(false);
    }

}
