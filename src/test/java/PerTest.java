import org.junit.Test;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class PerTest extends AbstractTest {
    @Test
    public void first() throws IOException {
        runTest(1, new Per()::solve);
    }

    @Override
    protected String getDir() {
        return "per/";
    }
}