import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class EligibilityTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new Eligibility()::solve);
    }

    @Override
    protected String getDir() {
        return "eligibility";
    }
}