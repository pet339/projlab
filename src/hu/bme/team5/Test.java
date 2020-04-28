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
                    playerShovelSnowTest(line, raf.readLine());
                }
                break;
                case "dig": {
                    playerStepsOnHoleTest(line, raf.readLine());
                }
                break;
                case "give": {
                    playerDigsItemTest(line, raf.readLine());
                }
                break;
                case "eat": {

                    playerTradesItemTest(line, raf.readLine());
                }
                break;
                case "inspect": {
                    playerEatsTest(line, raf.readLine());

                }
                break;
                case "igloo": {
                    playerExploreTest(line, raf.readLine());

                }
                break;
                case "save": {
                    playerEskimoBuildsIglooTest(line, raf.readLine());

                }
                break;
                case "aasemble": {
                    playerSavesPlayerTest(line, raf.readLine());

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

    /*
     * @param input: String, output: String
     * @return void
     */
    public void initTest(String input, String output) {

    }

    /*
     * @param input: String, output: String
     * @return void
     */
    public void playerStepTest(String input, String output) {

    }

    public boolean playerShovelSnowTest(String input, String output) {
        return true;
    }

    public boolean playerStepsOnHoleTest(String input, String output) {
        return true;
    }

    public boolean playerDigsItemTest(String input, String output) {
        return true;
    }

    public boolean playerTradesItemTest(String input, String output) {
        return true;
    }

    public boolean playerEatsTest(String input, String output) {
        return true;
    }

    public boolean playerExploreTest(String input, String output) {
        return true;
    }

    public boolean playerEskimoBuildsIglooTest(String input, String output) {
        return true;
    }

    public boolean playerSavesPlayerTest(String input, String output) {
        return true;
    }

    public boolean playerAssemblesTest(String input, String output) {
        return true;
    }
}
