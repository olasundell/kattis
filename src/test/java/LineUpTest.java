import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class LineUpTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new LineUp()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new LineUp()::solve);
    }

    @Test
    public void three() throws IOException {
        runTest(3, new LineUp()::solve);
    }

    @Override
    protected String getDir() {
        return "lineup";
    }
}