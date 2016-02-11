import org.junit.Test;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class FridayTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new Friday()::solve);
    }

    @Override
    protected String getDir() {
        return "friday";
    }
}