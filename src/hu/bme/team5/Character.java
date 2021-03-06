package hu.bme.team5;

public abstract class Character implements TurnBased, Controllable {
    
    protected Field currentField; //A field amin a karakter áll
    protected int health; //A karakter életét tartalmazó integer
    protected int work; //A karakter munkáját tartalmazó integer 
    protected boolean drowning; //A karakter éppen foldiklik e
    protected Inventory inventory; //A karakter inventoryja
    protected String name;
    //Konstruktor
    public Character() {
        inventory = new Inventory();
    }
    public Character(String name){
        this.name = name;
        inventory = new Inventory();
    }


    public void printState() {
        System.out.println(health);
        System.out.println(work);
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
            if (i1 == null){
                System.out.println("Nincs ilyen item");
            }
            else{
                Inventory nv = c.getInventory();
                inventory.tradeWithInventory(nv, i1);
                System.out.println("Sikeres atadas");
            }

        }
    }

    //Ezek működése a későbbiekben lesz megvalósítva
    @Override
    public void endTurn() {
        if (health < 1 || isDrowning()){
           currentField.gameEnded(false);
        }
        work = 4;
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

        if (nextField.polarBear){
            System.out.println("Sajnalattal ertesitjuk, hogy Ont felfalta egy medve!");
            currentField.gameEnded(false);
        }
        //Elveszünk 1 munkát, a fieldek elvégzik a karakterek kezelését.
        setWork(work-1);
        currentField.removeCharacter(this);
        setCurrentField(nextField);
        currentField.stepOn(this);

        return true;
    }

    //karakter havat takarít
    @Override
    public boolean shovelSnow() {
        //Munka ellenőrzése
        if(work==0){
            System.out.println("Nincs eleg munka");
            return false;
        }

        //Hó nagyságának ellenőrzése
        if(currentField.snowSize==0){
            System.out.println("A mezo tiszta");
            return false;
        }

        //Megnézzük hogy van e ásónk , belső működése az inventory felelőssége
        if(inventory.shovelSnowUsed()){
            currentField.setSnowSize(Math.max(currentField.snowSize-2, 0));
        }
        else currentField.setSnowSize(currentField.snowSize-1);

        System.out.println("Sikeres asas");
        setWork(work - 1);
        return true;
    }

    //Karakter kiás egy itemet
    public boolean digItem(){
        //Hó nagyságának ellenőrzése
        if(currentField.snowSize!=0){
            System.out.println("A ho miatt nem lehet asni");
            return false;
        }

        //Munka ellenőrzése
        if(work==0){
            System.out.println("Nincs munka, nem lehet asni.");
            return false;
        }

        //Van e a táblában befagyott item
        if(currentField.getFrozenItem()==null){
            System.out.println("\t-Nincs targy, nincs mit kiasni.");
            return false;
        }

        //Az inventoryba rakjuk az itemet
        Item i = currentField.getFrozenItem();
        inventory.addItem(i);
        currentField.setFrozenItem(null);
        setWork(work - 1);
        System.out.println("Sikeresen kiastad: " + i.name);
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
        for (Character c : currentField.map.characters) {
            if (c.currentField != currentField) {
                System.out.println("Nem azonos mezon all az osszes karakter");
                return false;
            }
        }
        currentField.gameEnded(true);
        setWork(work - 1);
        return true;
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
                System.out.println("Szovetseges sikeresen megmentve");
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
        //Az inventory kideríti hogy van e nála búvárruha
        boolean b2 = inventory.drownUsed();
        if (!b2){
            System.out.println("Lyukba esett a karakter es fuldokol");
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
            System.out.println("Nem sikerult");
            return false;
        }
        setHealth(health+1);
        inventory.removeFood();
        System.out.println("Uj elet: "+ health);
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
            setWork(work - 1);
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
    
    int explore(Field f) {
        System.out.println("nem explorer vagy");
        return -10;
    }
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

    public void Spell(Field f){
        int result = explore(f);
        if (result == -10){
            buildIgloo();
        }
    }

    public String draw(){
        return null;
    }

}
