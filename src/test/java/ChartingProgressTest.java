import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class ChartingProgressTest extends AbstractTest {
    @Test
    public void one() throws IOException {
        runTest(1, new ChartingProgress()::solve);
    }

    @Override
    protected String getDir() {
        return "chartingprogress";
    }
}