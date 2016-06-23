import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

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