import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class TrollHuntTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new TrollHunt()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new TrollHunt()::solve);
	}

	@Override
	protected String getDir() {
		return "trollhunt";
	}
}