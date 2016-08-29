import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class SecretMessageTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new SecretMessage()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new SecretMessage()::solve);
    }

    @Test
    public void three() throws IOException {
        runTest(3, new SecretMessage()::solve);
    }

    @Override
    protected String getDir() {
        return "secretmessage";
    }
}