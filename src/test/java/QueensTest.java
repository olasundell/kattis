import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class QueensTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new Queens()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new Queens()::solve);
    }

    @Test
    public void three() throws IOException {
        runTest(3, new Queens()::solve);
    }

    @Override
    protected String getDir() {
        return "queens/";
    }
}