import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class MixedFractionsTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new MixedFractions()::solve);
    }

    @Override
    protected String getDir() {
        return "mixedfractions/";
    }
}