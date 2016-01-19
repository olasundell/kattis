import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class ApaxiaaansTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new Apaxiaaans()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new Apaxiaaans()::solve);
    }

    @Test
    public void three() throws IOException {
        runTest(3, new Apaxiaaans()::solve);
    }

    @Override
    protected String getDir() {
        return "apaxiaaans";
    }
}