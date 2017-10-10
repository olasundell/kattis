import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class BackspaceTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Backspace()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new Backspace()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new Backspace()::solve);
	}

	@Override
	protected String getDir() {
		return "backspace";
	}
}