package hu.bme.team5;

public class Eskimo extends Character {

    //Konstruktor
    public Eskimo() {
        super();
        health = 5;
    }

    //Iglu építés
    @Override
    public boolean buildIgloo() {
        //Munka ellenőrzés
    	if(this.work == 0) {
            System.out.println("Nincs eleg munkaegyseg az epiteshez");
    		return false;
        }
        
        //Munka csökkentés iglu építése
    	setWork(work - 1);
    	currentField.setIgloo(true);
    	return true;
    }
}
