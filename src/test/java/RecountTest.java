import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class RecountTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Recount()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new Recount()::solve);
	}

	@Override
	protected String getDir() {
		return "recount";
	}
}