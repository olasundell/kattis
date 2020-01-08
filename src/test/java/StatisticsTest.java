import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class StatisticsTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new Statistics()::solve);
    }

    @Override
    protected String getDir() {
        return "statistics";
    }
}