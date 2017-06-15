import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class CompassTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Compass()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new Compass()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new Compass()::solve);
	}

	@Override
	protected String getDir() {
		return "compass";
	}
}