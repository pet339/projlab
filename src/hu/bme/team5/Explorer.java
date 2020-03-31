package hu.bme.team5;

public class Explorer extends Character {
    public Explorer() {
        super();
    }

    //Felderít egy paraméterként kapott jégtáblát
    @Override
    public boolean explore(Field f) {
        System.out.println(">Explorer.explore()");
        
        //Munka ellenőrzése
    	if(work==0){
    	    System.out.println("-Nincs munka, nem lehet dolgozni.");
            System.out.println("<Explorer.explore()");
            return false;
        }

        //Megnézzük ,hogy szomszédos e a mező
    	if(!currentField.checkNeighbor(f)&&currentField!=f){
            System.out.println("-Nem szomszedos vagy aktualis mezo, tul messze van.");
            System.out.println("<Explorer.explore()");
            return false;
        }

        //Kiírjuk a kapacitást
    	System.out.println("-Kapacitas: " + f.getCapacity());
    	System.out.println("<Explorer.explore()");
    	return true;
    }
}
