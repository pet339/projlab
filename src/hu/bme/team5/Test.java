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
                    Explorer explorer = new Explorer();
                    explorer.setWork(1);
                    Field field = null;
                    for (Field f : testGame.currentMap.fields)
                        if (f.getId() == Integer.parseInt(line.split(" ")[1]))
                            explorer.setCurrentField(f);
                    for (Field f : testGame.currentMap.fields)
                        if (f.getId() == Integer.parseInt(line.split(" ")[2])) {
                            explorer.move(f);
                            field = f;
                        }
                    if (field.getClass().getSimpleName().equals("Hole"))
                        printer(field.getId() == Integer.parseInt(raf.readLine())
                                && explorer.isDrowning());
                    else
                        printer(field.getId() == Integer.parseInt(raf.readLine()));
                }
                break;
                case "shovel": {
                    System.out.print("shovelTest: ");

                    Explorer explorer = new Explorer();
                    explorer.setWork(1);
                    Field field = testGame.currentMap.fields.get(0);
                    field.setSnowSize(1);

                    explorer.setCurrentField(field);
                    explorer.shovelSnow();

                    line = raf.readLine();
                    printer(explorer.work == Integer.parseInt(line.split(" ")[0])
                            && field.snowSize == Integer.parseInt(line.split(" ")[1]));

                }
                break;
                case "dig": {
                }
                break;
                case "give": {
                }
                break;
                case "eat": {

                }
                break;
                case "inspect": {

                }
                break;
                case "igloo": {

                }
                break;
                case "save": {

                }
                break;
                case "aasemble": {

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
