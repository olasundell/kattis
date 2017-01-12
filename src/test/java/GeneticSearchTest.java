import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class GeneticSearchTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new GeneticSearch()::solve);
	}

	@Override
	protected String getDir() {
		return "geneticsearch";
	}
}