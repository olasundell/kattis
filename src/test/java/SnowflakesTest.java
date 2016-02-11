import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * TODO write documentation
 */
public class SnowflakesTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new Snowflakes()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new Snowflakes()::solve);
    }

    @Test
    public void three() throws IOException {
        runTest(3, new Snowflakes()::solve);
    }

    @Test
    @Ignore("probably broken data")
    public void four() throws IOException {
        runTest(4, new Snowflakes()::solve);
    }

    @Test
    public void five() throws IOException {
        runTest(5, new Snowflakes()::solve);
    }

    @Test
    public void six() throws IOException {
        runTest(6, new Snowflakes()::solve);
    }

//    @Test
    public void writeFile() throws IOException {
        Random random = new Random(0);
        String path = "/Users/olasundell/code/kattis/src/test/resources/snowflakes";
        File in = new File(path + "/4.in");
        File ans = new File(path + "/4.ans");

        FileWriter fw = new FileWriter(in);

        fw.write("1\n");

        int noOfFlakes = 1_000_000;
        fw.write(noOfFlakes + "\n");
        Set<Integer> flakes = new LinkedHashSet<>();

        for (int i = 0; i < noOfFlakes; i++) {
            int flake = random.nextInt(1_000_000_000);
            flakes.add(flake);
            fw.write(flake + "\n");
        }

        fw.close();

        fw = new FileWriter(ans);
        fw.write(String.valueOf(flakes.size()));
        fw.close();
    }

    @Override
    protected String getDir() {
        return "snowflakes";
    }
}