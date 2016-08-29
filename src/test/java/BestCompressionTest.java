import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class BestCompressionTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new BestCompression()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new BestCompression()::solve);
    }

    @Test
    public void three() throws IOException {
        runTest(3, new BestCompression()::solve);
    }

    @Override
    protected String getDir() {
        return "bestcompression";
    }
}