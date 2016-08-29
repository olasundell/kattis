import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class BusNumbersTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new BusNumbers()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new BusNumbers()::solve);
    }

    @Test
    public void three() throws IOException {
        runTest(3, new BusNumbers()::solve);
    }

    @Test
    public void four() throws IOException {
        runTest(4, new BusNumbers()::solve);
    }

    @Override
    protected String getDir() {
        return "busnumbers";
    }
}