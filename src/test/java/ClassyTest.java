import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

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