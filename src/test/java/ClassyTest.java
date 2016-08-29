import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class ClassyTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Classy()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new Classy()::solve);
	}

	@Override
	protected String getDir() {
		return "classy";
	}
}