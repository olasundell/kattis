import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class ParkingTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new Parking()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new Parking()::solve);
    }

    @Override
    protected String getDir() {
        return "parking";
    }
}