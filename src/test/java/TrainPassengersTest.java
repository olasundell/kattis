import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class TrainPassengersTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new TrainPassengers()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new TrainPassengers()::solve);
    }

    @Test
    public void three() throws IOException {
        runTest(3, new TrainPassengers()::solve);
    }

    @Test
    public void four() throws IOException {
        runTest(4, new TrainPassengers()::solve);
    }

    @Override
    protected String getDir() {
        return "trainpassengers";
    }
}