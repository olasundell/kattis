import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class CommunicationTest extends AbstractTest {

    @Test
    @Disabled("does not work")
    public void one() throws IOException {
        runTest(1, new Communication()::solve);
    }

    @Override
    protected String getDir() {
        return "communication";
    }
}