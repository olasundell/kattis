import org.junit.Ignore;
import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class AlphabetSpamTest extends AbstractTest {

    @Test
    @Ignore
    public void one() throws IOException {
        runTest(1, new AlphabetSpam()::solve);
    }

    @Test
    @Ignore
    public void two() throws IOException {
        runTest(2, new AlphabetSpam()::solve);
    }

    @Override
    protected String getDir() {
        return "alphabetspam";
    }
}