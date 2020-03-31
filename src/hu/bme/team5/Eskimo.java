package hu.bme.team5;

public class Eskimo extends Character {
    public Eskimo() {
        super();
    }

    @Override
    public boolean buildIgloo() {
        System.out.println(">buildIgloo()");
    	if(this.work == 0) {
            System.out.println("Nincs eleg munkaegyseg az epiteshez");
            System.out.println("<buildIgloo()");
    		return false;
    	}
    	setWork(work - 1);
    	currentField.setIgloo(true);
        System.out.println("<buildIgloo()");
    	return true;
    }
}
