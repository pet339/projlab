package hu.bme.team5;

public class Explorer extends Character {
    public Explorer() {
        super();
        health = 4;
        this.work = 4;

    }

    public Explorer(String name) {
        super();
        health = 4;
        this.work = 4;
        this.name = name;
    }

    //Felderít egy paraméterként kapott jégtáblát
    @Override
    public int explore(Field f) {
        //Munka ellenőrzése
    	if(work==0){
    	    System.out.println("Nincs eleg munka!");
            return -1;
        }

        //Megnézzük, hogy szomszédos e a mező
    	if(!currentField.checkNeighbor(f) && currentField != f){
            System.out.println("Hibas mezo!");
            return -1;
        }

        //Csökkentjük a munkát és kiírjuk a kapacitást
        System.out.println("Sikeres vizsgalat");
        setWork(work-1);
    	return f.getCapacity();
    }

    @Override
    public String draw() {
        return "bin/img/pix_dora.png";
    }
}
