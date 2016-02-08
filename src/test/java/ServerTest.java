import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

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