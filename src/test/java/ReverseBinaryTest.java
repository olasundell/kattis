import org.junit.Test;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class ReverseBinaryTest extends AbstractTest {
    @Test
    public void one() throws IOException {
        runTest(1, new ReverseBinary()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new ReverseBinary()::solve);
    }

    @Override
    protected String getDir() {
        return "reversebinary/";
    }
}