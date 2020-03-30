package hu.bme.team5;

public class Hole extends Field {
    public Hole() {
        super();
    }

    @Override
    public void stepOn(Character c) {
        System.out.println("    >setCharacter(c)");
        setCharacter(c);
        System.out.println("    <setCharacter(c)");

        System.out.println("    >setSnowSize(0)");
        setSnowSize(0);
        System.out.println("    <setSnowSize(0)");

        System.out.println("    >characters.get(characters.size()-1).drown()");
        characters.get(characters.size()-1).drown();

        System.out.println("    <characters.get(characters.size()-1).drown()");
    }
}
