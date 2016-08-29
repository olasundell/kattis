import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class ClosingTheLoopTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new ClosingTheLoop()::solve);
    }

    @Override
    protected String getDir() {
        return "closingtheloop";
    }
}