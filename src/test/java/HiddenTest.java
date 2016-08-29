import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class HiddenTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new Hidden()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new Hidden()::solve);
    }

    @Test
    public void three() throws IOException {
        runTest(3, new Hidden()::solve);
    }

    @Test
    public void four() throws IOException {
        runTest(4, new Hidden()::solve);
    }

    @Test
    public void five() throws IOException {
        runTest(5, new Hidden()::solve);
    }

    @Override
    protected String getDir() {
        return "hidden";
    }
}