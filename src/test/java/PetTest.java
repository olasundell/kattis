import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class PetTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new Pet()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new Pet()::solve);
    }

    @Override
    protected String getDir() {
        return "pet/";
    }
}