package hu.bme.team5;

public class Explorer extends Character {
    public Explorer() {
        super();
    }

    @Override
    public boolean explore(Field f) {
    	System.out.println(">Explorer.explore()");
    	if(work==0){
    	    System.out.println("-Nincs munka, nem lehet dolgozni.");
            System.out.println("<Explorer.explore()");
            return false;
        }
    	if(!currentField.checkNeighbor(f)&&currentField!=f){
            System.out.println("-Nem szomszedos vagy aktualis mezo, tul messze van.");
            System.out.println("<Explorer.explore()");
            return false;
        }
    	System.out.println("-Kapacitas: " + f.getCapacity());
    	System.out.println("<Explorer.explore()");
    	return true;
    }
}
