import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class ChopinTest extends AbstractTest {

	private Chopin chopin;

	@BeforeEach
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