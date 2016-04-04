import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class VolimTest extends AbstractTest {
    @Test
    public void one() throws IOException {
        runTest(1, new Volim()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new Volim()::solve);
    }

    @Test
    public void three() throws IOException {
        runTest(3, new Volim()::solve);
    }

    @Override
    protected String getDir() {
        return "volim";
    }
}