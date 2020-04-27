package hu.bme.team5;

public class Explorer extends Character {
    public Explorer() {
        super();
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

        //Kiírjuk a kapacitást
    	return f.getCapacity();
    }
}
