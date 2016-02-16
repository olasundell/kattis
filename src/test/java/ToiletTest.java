import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class ToiletTest extends AbstractTest {

    @Test
    @Ignore("Not implemented")
    public void one() throws IOException {
        runTest(1, new Toilet()::solve);
    }

    @Override
    protected String getDir() {
        return "toilet";
    }
}