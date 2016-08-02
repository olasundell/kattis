import org.junit.Test;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class TrikTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Trik()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new Trik()::solve);
	}

	@Override
	protected String getDir() {
		return "trik";
	}
}