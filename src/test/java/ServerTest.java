import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class ServerTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new Server()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new Server()::solve);
    }

    @Override
    protected String getDir() {
        return "server";
    }
}