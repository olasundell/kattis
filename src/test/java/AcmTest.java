import org.junit.Test;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class AcmTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new Acm()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new Acm()::solve);
    }

    @Override
    protected String getDir() {
        return "acm/";
    }
}