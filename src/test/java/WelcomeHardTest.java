import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class WelcomeHardTest extends AbstractTest {

    @Test
    @Disabled
    public void one() throws IOException {
        runTest(1, new WelcomeHard()::solve);
    }

    @Override
    protected String getDir() {
        return "welcomehard";
    }
}