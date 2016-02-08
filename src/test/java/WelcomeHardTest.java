import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

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