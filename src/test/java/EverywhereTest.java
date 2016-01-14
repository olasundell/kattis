import org.junit.Test;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class EverywhereTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new Everywhere()::solve);
    }

    @Override
    protected String getDir() {
        return "everywhere/";
    }
}