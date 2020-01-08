import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class BijeleTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Bijele()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new Bijele()::solve);
	}

	@Override
	protected String getDir() {
		return "bijele";
	}
}