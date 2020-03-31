package hu.bme.team5;

public class Stable extends Iceberg {
    public Stable() {
        super();
        capacity=map.characters.size()+1;
    }

    // Karakter rálép egy mezőre
    @Override
    public void stepOn(Character c) {
        System.out.println(">stepOn(c)");
        setCharacter(c);
        System.out.println("<stepOn(c)");
    }
}
