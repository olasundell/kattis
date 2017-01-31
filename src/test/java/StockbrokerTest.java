import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;
import java.util.Arrays;

/**
 * TODO write documentation
 */
public class StockbrokerTest extends AbstractTest {

	private Stockbroker stockbroker;

	@Before
	public void setUp() throws Exception {
		stockbroker = new Stockbroker();
	}

	@Test
	public void one() throws IOException {
		runTest(1, stockbroker::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, stockbroker::solve);
	}

	@Test
	public void findLocalMinShouldFindFoundFinders() {
		Stockbroker.State state = new Stockbroker.State();
		state.priceOverTime = Arrays.asList(100, 75, 150);
		Assert.assertEquals(1, stockbroker.findLocalMin(state));

		state.priceOverTime = Arrays.asList(100, 175, 150);
		Assert.assertEquals(0, stockbroker.findLocalMin(state));

		state.priceOverTime = Arrays.asList(100, 75, 50);
		Assert.assertEquals(2, stockbroker.findLocalMin(state));
	}

	@Test
	public void findLocalMaxShouldFindFoundFinders() {
		Stockbroker.State state = new Stockbroker.State();
		state.priceOverTime = Arrays.asList(100, 175, 150);
		Assert.assertEquals(1, stockbroker.findLocalMax(state));

		state.priceOverTime = Arrays.asList(100, 75, 150);
		Assert.assertEquals(0, stockbroker.findLocalMax(state));
	}

	@Override
	protected String getDir() {
		return "stockbroker";
	}
}