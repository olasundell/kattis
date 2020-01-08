import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * TODO write documentation
 */
public class EasiestTest extends AbstractTest {

    private Easiest easiest;

    @BeforeEach
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
        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Override
    protected String getDir() {
        return "easiest";
    }
}