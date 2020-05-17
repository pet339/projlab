package hu.bme.team5;

public class Eskimo extends Character {

    //Konstruktor
    public Eskimo() {
        super();
        health = 5;
        this.work = 4;
    }


    public Eskimo(String name) {
        super();
        health = 5;
        this.work = 4;
        this.name = name;
    }

    //Iglu építés
    @Override
    public boolean buildIgloo() {
        //Munka ellenőrzés
    	if(this.work == 0) {
            System.out.println("Nincs eleg munkaegyseg az epiteshez");
    		return false;
        }
    	if(this.currentField.igloo){
    	    System.out.println("Mar van iglu ezen a mezon");
    	    return false;
        }
        
        //Munka csökkentés iglu építése
        System.out.println("Sikeres iglu epites");
    	setWork(work - 1);
    	currentField.setIgloo(true);
    	return true;
    }

    @Override
    public String draw() {
        return "src/img/pix_eskimo.png";
    }
}
