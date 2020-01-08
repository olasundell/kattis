import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class TowersTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new Towers()::solve);
    }

    @Override
    protected String getDir() {
        return "towers/";
    }
}