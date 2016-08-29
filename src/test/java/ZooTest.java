import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class ZooTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Zoo()::solve);
	}

	@Override
	protected String getDir() {
		return "zoo";
	}
}