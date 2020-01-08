import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class QueensTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new Queens()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new Queens()::solve);
    }

    @Test
    public void three() throws IOException {
        runTest(3, new Queens()::solve);
    }

    @Override
    protected String getDir() {
        return "queens/";
    }
}