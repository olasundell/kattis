import org.junit.Test;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class ZamkaTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Zamka()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new Zamka()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new Zamka()::solve);
	}

	@Override
	protected String getDir() {
		return "zamka";
	}
}