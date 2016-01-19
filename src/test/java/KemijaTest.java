import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class KemijaTest extends AbstractTest {
    @Test
    public void one() throws IOException {
        runTest(1, new Kemija()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new Kemija()::solve);
    }

    @Test
    public void three() throws IOException {
        runTest(3, new Kemija()::solve);
    }

    @Test
    public void four() throws IOException {
        runTest(4, new Kemija()::solve);
    }

    @Override
    protected String getDir() {
        return "kemija/";
    }
}