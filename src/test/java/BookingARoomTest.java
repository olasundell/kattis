import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class BookingARoomTest extends AbstractTest {

    @Test
    @Disabled("Faulty test data")
    public void one() throws IOException {
        runTest(1, new BookingARoom()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new BookingARoom()::solve);
    }

    @Override
    protected String getDir() {
        return "bookingaroom";
    }
}