import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class SimonSaysTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new SimonSays()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new SimonSays()::solve);
    }

    @Test
    public void three() throws IOException {
        runTest(3, new SimonSays()::solve);
    }

    @Override
    protected String getDir() {
        return "simonsays";
    }
}