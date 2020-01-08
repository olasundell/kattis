package hackerrank;

import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class CavityTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Cavity()::solve);
	}

	@Override
	protected String getDir() {
		return "hackerrank/cavity";
	}
}