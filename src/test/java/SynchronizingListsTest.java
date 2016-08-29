import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class SynchronizingListsTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new SynchronizingLists()::solve);
    }

    @Override
    protected String getDir() {
        return "synchronizinglists";
    }
}