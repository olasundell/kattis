import org.junit.Test;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class OdditiesTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new Oddities()::solve);
    }

    @Override
    protected String getDir() {
        return "oddities/";
    }
}