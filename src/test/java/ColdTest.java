import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class ColdTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new Cold()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new Cold()::solve);
    }

    @Override
    protected String getDir() {
        return "cold";
    }
}