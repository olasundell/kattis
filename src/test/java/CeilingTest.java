import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class CeilingTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Ceiling()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new Ceiling()::solve);
	}

	@Override
	protected String getDir() {
		return "ceiling";
	}
}