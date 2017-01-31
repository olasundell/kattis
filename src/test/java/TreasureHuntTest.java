import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class TreasureHuntTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new TreasureHunt()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new TreasureHunt()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new TreasureHunt()::solve);
	}

	@Override
	protected String getDir() {
		return "treasurehunt";
	}
}