import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class DiceGameTest extends AbstractTest {
    @Test
    public void one() throws IOException {
        runTest(1, new DiceGame()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new DiceGame()::solve);
    }

    @Test
    public void three() throws IOException {
        runTest(3, new DiceGame()::solve);
    }

    @Override
    protected String getDir() {
        return "dicegame/";
    }
}