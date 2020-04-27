package hu.bme.team5;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Test {
    //private Game testGame = new Game();
    private int testNum = 1;

    public Test() throws IOException {
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

    public boolean initTest(String input, String output) {
        return true;
    }

    public boolean playerStepTest(String input, String output) {
        return true;

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
