package hu.bme.team5;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Test {
    static Game testGame = new Game();
    private int testNum = 1;

    /*
        test.txt beolvasása és tesztelés
    */

    public Test() throws IOException {
        testGame.currentMap.init();
        RandomAccessFile raf = new RandomAccessFile("test.txt", "r");
        for (String line = raf.readLine(); line != null; line = raf.readLine()) {
            if (line.equals("")) {
                testNum++;
                continue;
            }
            switch (testNum) {
                case 1: {
                    initTest(line, raf.readLine());
                }
                break;
                case 2: {
                    playerStepTest(line, raf.readLine());
                }
                break;
                case 3: {
                    playerShovelSnowTest(line, raf.readLine());
                }
                break;
                case 4: {
                    playerStepsOnHoleTest(line, raf.readLine());
                }
                break;
                case 5: {
                    playerDigsItemTest(line, raf.readLine());
                }
                break;
                case 6: {

                    playerTradesItemTest(line, raf.readLine());
                }
                break;
                case 7: {
                    playerEatsTest(line, raf.readLine());

                }
                break;
                case 8: {
                    playerExploreTest(line, raf.readLine());

                }
                break;
                case 9: {
                    playerEskimoBuildsIglooTest(line, raf.readLine());

                }
                break;
                case 10: {
                    playerSavesPlayerTest(line, raf.readLine());

                }
                break;
                case 11: {
                    playerAssemblesTest(line, raf.readLine());

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
        printer(result.equals(output));
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
