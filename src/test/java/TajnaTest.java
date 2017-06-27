import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class TajnaTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Tajna()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new Tajna()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new Tajna()::solve);
	}

	@Override
	protected String getDir() {
		return "tajna";
	}
}