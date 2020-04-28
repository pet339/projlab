package hu.bme.team5;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Test {
    static Game testGame = new Game();
    /*
        test.txt beolvasása és tesztelés
    */

    public Test() throws IOException {
        testGame.currentMap.init();
        RandomAccessFile raf = new RandomAccessFile("test.txt", "r");
        for (String line = raf.readLine(); line != null; line = raf.readLine()) {

            switch (line.split(" ")[0]) {
                case "init": {
                    System.out.print("initTest: ");
                    String result = "";
                    for (Field f : testGame.currentMap.fields) {
                        StringBuilder neighborsID = new StringBuilder();
                        for (Field n : f.getNeighbors()) {
                            neighborsID.append(n.getId() + ",");
                        }
                        neighborsID.delete(neighborsID.toString().length() - 1, neighborsID.toString().length());
                        result += f.getClass().getSimpleName() + "{[Field:id=" + f.getId() + ";neighbors:"
                                + neighborsID.toString() + "]};";
                    }
                    printer(result.equals(raf.readLine()));
                }
                break;
                case "step": {
                    System.out.print("stepTest: ");
                    Character c = new Explorer();
                    c.setWork(1);
                    Field field = null;
                    for (Field f : testGame.currentMap.fields)
                        if (f.getId() == Integer.parseInt(line.split(" ")[1]))
                            c.setCurrentField(f);
                    for (Field f : testGame.currentMap.fields)
                        if (f.getId() == Integer.parseInt(line.split(" ")[2])) {
                            c.move(f);
                            field = f;
                        }
                    if (field.getClass().getSimpleName().equals("Hole"))
                        printer(field.getId() == Integer.parseInt(raf.readLine())
                                && c.isDrowning());
                    else
                        printer(field.getId() == Integer.parseInt(raf.readLine()));
                }
                break;
                case "shovel": {
                    System.out.print("shovelTest: ");

                    Character c = new Explorer();
                    c.setWork(1);
                    Field field = testGame.currentMap.fields.get(0);
                    field.setSnowSize(1);

                    c.setCurrentField(field);
                    c.shovelSnow();

                    line = raf.readLine();
                    printer(c.work == Integer.parseInt(line.split(" ")[0])
                            && field.snowSize == Integer.parseInt(line.split(" ")[1]));

                }
                break;
                case "dig": {
                    System.out.print("digTest: ");

                    Character c = new Explorer();
                    c.setWork(1);
                    Field field = testGame.currentMap.fields.get(0);
                    field.setFrozenItem(new Gun());
                    c.setCurrentField(field);
                    c.digItem();
                    line = raf.readLine();
                    printer(c.work == Integer.parseInt(line.split(" ")[0])
                            && c.inventory.items.size() == Integer.parseInt(line.split(" ")[1]));
                }
                break;
                case "give": {
                    System.out.print("giveTest: ");

                    Character c1 = new Explorer();
                    Character c2 = new Eskimo();
                    Item item = null;
                    if (line.split(" ")[1].equals("gun"))
                        item = new Gun();
                    c1.inventory.addItem(item);
                    c1.trade(c2, item);

                    line = raf.readLine();
                    printer(c1.inventory.items.size() == Integer.parseInt(line.split(" ")[0])
                            && c2.inventory.items.size() == Integer.parseInt(line.split(" ")[1]));

                }
                break;
                case "eat": {
                    System.out.print("eatTest: ");

                    Character c = new Explorer();
                    c.inventory.addItem(new Food());
                    c.eat();

                    line = raf.readLine();
                    printer(c.inventory.items.size() == Integer.parseInt(line.split(" ")[0])
                            && c.health == Integer.parseInt(line.split(" ")[1]));
                }
                break;
                case "inspect": {
                    System.out.print("inspectTest: ");
                    Character c = new Explorer();
                    c.setWork(1);
                    c.setCurrentField(testGame.currentMap.fields.get(0));
                    Field field = c.currentField.neighbors.get(0);
                    int capacity = c.explore(field);

                    line = raf.readLine();
                    printer(c.work == Integer.parseInt(line.split(" ")[0])
                            && capacity == Integer.parseInt(line.split(" ")[1]));

                }
                break;
                case "igloo": {
                    System.out.print("iglooTest: ");
                    Character c = new Eskimo();
                    c.setWork(1);
                    Field field = testGame.currentMap.fields.get(0);
                    c.setCurrentField(field);
                    c.buildIgloo();

                    line = raf.readLine();
                    printer(c.work == Integer.parseInt(line.split(" ")[0])
                            && field.igloo == Boolean.parseBoolean(line.split(" ")[1]));
                }
                break;
                case "save": {
                    System.out.print("saveTest: ");
                    Character c1 = new Eskimo();
                    Character c2 = new Explorer();
                    c1.setWork(1);
                    c2.setWork(1);
                    Item rope = new Rope();
                    c1.inventory.addItem(rope);
                    Field field = testGame.currentMap.fields.get(2);

                    c1.setCurrentField(field);
                    c2.setCurrentField(field);

                    Field hole = c1.currentField.neighbors.get(2);

                    c2.move(hole);
                    c1.saveAlly(c2);

                    line = raf.readLine();
                    printer(c1.work == Integer.parseInt(line.split(" ")[0])
                            && c1.inventory.items.contains(rope) == Boolean.parseBoolean(line.split(" ")[1])
                            && c2.isDrowning() == Boolean.parseBoolean(line.split(" ")[2]));
                }
                break;
                case "assemble": {

                }
                break;
                default:
                    break;
            }
        }
        raf.close();

    }


    void printer(boolean result) {
        if (result)
            System.out.println("Success");
        else
            System.out.println("Fail");
    }
}
