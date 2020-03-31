package hu.bme.team5;

public class Eskimo extends Character {

    //Konstruktor
    public Eskimo() {
        super();
    }

    //Iglu építés
    @Override
    public boolean buildIgloo() {
        System.out.println(">buildIgloo()");

        //Munka ellenőrzés
    	if(this.work == 0) {
            System.out.println("Nincs eleg munkaegyseg az epiteshez");
            System.out.println("<buildIgloo()");
    		return false;
        }
        
        //Munka csökkentés iglu építése
    	setWork(work - 1);
    	currentField.setIgloo(true);
        System.out.println("<buildIgloo()");
    	return true;
    }
}
