import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class AaahTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new Aaah()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new Aaah()::solve);
    }

    @Override
    protected String getDir() {
        return "aaah";
    }
}