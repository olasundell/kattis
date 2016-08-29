import org.junit.Ignore;
import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class WelcomeHardTest extends AbstractTest {

    @Test
    @Ignore
    public void one() throws IOException {
        runTest(1, new WelcomeHard()::solve);
    }

    @Override
    protected String getDir() {
        return "welcomehard";
    }
}