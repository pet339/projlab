package hu.bme.team5;

public class Stable extends Iceberg {
    public Stable() {
        super();
        capacity=map.characters.size()+1;
    }

    @Override
    public void stepOn(Character c) {
        System.out.println(">setCharacter(c)");
        setCharacter(c);
        System.out.println("<setCharacter(c)");
    }
}
