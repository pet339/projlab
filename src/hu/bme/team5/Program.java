package hu.bme.team5;

public class Program {

    public static void main(String[] args) {
        //Elindítja a tesztelést
       /* try {
            Test test = new Test();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        //Létrehoz egy menüt, amely vezérli a játékot
        // Game g = new Game();
        // A statikus game-et használjuk 1 példányban
       // ActionMenu am = new ActionMenu(new Eskimo(), new Map(Menu.game));
        PlayPanel playPanel = new PlayPanel();
        BackGround backGround = new BackGround();
    }
}
