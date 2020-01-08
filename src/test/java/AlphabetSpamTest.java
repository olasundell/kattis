import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class AlphabetSpamTest extends AbstractTest {

    @Test
    @Disabled
    public void one() throws IOException {
        runTest(1, new AlphabetSpam()::solve);
    }

    @Test
    @Disabled
    public void two() throws IOException {
        runTest(2, new AlphabetSpam()::solve);
    }

    @Override
    protected String getDir() {
        return "alphabetspam";
    }
}