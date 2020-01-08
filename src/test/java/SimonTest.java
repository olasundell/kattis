import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class SimonTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new Simon()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new Simon()::solve);
    }

    @Test
    public void three() throws IOException {
        runTest(3, new Simon()::solve);
    }

    @Override
    protected String getDir() {
        return "simon";
    }
}