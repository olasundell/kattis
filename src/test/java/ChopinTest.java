import org.junit.Before;
import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class ChopinTest extends AbstractTest {

	private Chopin chopin;

	@Before
	public void setUp() throws Exception {
		chopin = new Chopin();
	}

	@Test
	public void one() throws IOException {
		runTest(1, chopin::solve);
	}

	@Override
	protected String getDir() {
		return "chopin";
	}
}