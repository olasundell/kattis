import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class ToiletTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new Toilet()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new Toilet()::solve);
    }

	@Test
	public void three() throws IOException {
		runTest(3, new Toilet()::solve);
	}

	@Test
	public void four() throws IOException {
		runTest(4, new Toilet()::solve);
	}

	@Test
	public void five() throws IOException {
		runTest(5, new Toilet()::solve);
	}

	@Test
	@Ignore("faulty data")
	public void six() throws IOException {
		runTest(6, new Toilet()::solve);
	}

	@Test
	public void seven() throws IOException {
		runTest(7, new Toilet()::solve);
	}

    @Override
    protected String getDir() {
        return "toilet";
    }
}