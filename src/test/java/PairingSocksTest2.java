import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class PairingSocksTest2 extends AbstractTest  {
	@Test
	public void one() throws IOException {
		runTest(1, new PairingSocksJ()::solve);
	}
	@Test
	public void two() throws IOException {
		runTest(2, new PairingSocksJ()::solve);
	}
	@Test
	public void three() throws IOException {
		runTest(3, new PairingSocksJ()::solve);
	}
	@Test
	public void four() throws IOException {
		runTest(4, new PairingSocksJ()::solve);
	}

	@Override
	protected String getDir() {
		return "pairingsocks";
	}
}