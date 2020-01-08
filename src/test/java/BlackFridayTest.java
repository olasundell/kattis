import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class BlackFridayTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new BlackFriday()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new BlackFriday()::solve);
    }

    @Override
    protected String getDir() {
        return "blackfriday";
    }
}