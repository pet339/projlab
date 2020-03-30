package hu.bme.team5;

public class Eskimo extends Character {
    public Eskimo() {
        super();
    }

    @Override
    public boolean buildIgloo() {
    	if(this.work == 0) {
    		return false;
    	}
    	return true;
    }
}
