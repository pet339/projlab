package hu.bme.team5;

public class Stable extends Iceberg {
    public Stable() {
        super();
    }

    @Override
    public void stepOn(Character c) {
        System.out.println(">setCharacter(c)");
        setCharacter(c);
        System.out.println("<setCharacter(c)");
    }
}
