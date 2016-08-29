import org.junit.Ignore;
import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class CommunicationTest extends AbstractTest {

    @Test
    @Ignore("does not work")
    public void one() throws IOException {
        runTest(1, new Communication()::solve);
    }

    @Override
    protected String getDir() {
        return "communication";
    }
}