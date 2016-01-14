import org.junit.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

/**
 * TODO write documentation
 */
public abstract class AbstractTest {
    protected final static String DIR = "/Users/olasundell/code/kattis/src/test/resources/";
    protected abstract String getDir();

    protected void runTest(int i, Function<Scanner, String> function) throws IOException {
        String result = function.apply(buildScanner(i + ".in"));
        String expected = readFile(i + ".ans");
        Assert.assertEquals(expected, result);
    }

    protected Scanner buildScanner(String s) throws FileNotFoundException {
        return new Scanner(new File(DIR + getDir() + s));
    }

    protected String readFile(String fileName) throws IOException {
        List<String> solution = new ArrayList<>();
        String line;

        final BufferedReader reader = new BufferedReader(new FileReader(DIR + getDir() + fileName));

        while ((line = reader.readLine()) != null) {
            solution.add(line);
        }

        return String.join("\n", solution);
    }
}
