import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * TODO write documentation
 */
public class EasiestTest extends AbstractTest {

    private Easiest easiest;

    @Before
    public void setUp() throws Exception {
        easiest = new Easiest();
    }

    @Test
    public void one() throws IOException {
        runTest(1, easiest::solve);
    }

    @Test
    public void shouldSplit() {
        List<Integer> result = easiest.split("123");
        Assert.assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Override
    protected String getDir() {
        return "easiest";
    }
}