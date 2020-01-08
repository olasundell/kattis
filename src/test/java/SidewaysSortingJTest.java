import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class SidewaysSortingJTest extends AbstractTest  {
	@Test
	public void one() throws IOException {
		runTest(1, new SidewaysSortingJ()::solve);
	}

	@Override
	protected String getDir() {
		return "sidewayssorting";
	}
}