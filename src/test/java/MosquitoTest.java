import org.junit.Test;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class MosquitoTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new Mosquito()::solve);
    }

    @Override
    protected String getDir() {
        return "mosquito";
    }
}