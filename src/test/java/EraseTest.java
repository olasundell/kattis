import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class EraseTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new Erase()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new Erase()::solve);
    }

    @Override
    protected String getDir() {
        return "erase";
    }
}