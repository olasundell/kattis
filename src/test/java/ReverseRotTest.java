import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class ReverseRotTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new ReverseRot()::solve);
    }

    @Override
    protected String getDir() {
        return "reverserot";
    }
}