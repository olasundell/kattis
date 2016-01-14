import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;

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