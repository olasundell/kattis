import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class SecureDoorsTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new SecureDoors()::solve);
	}

	@Override
	protected String getDir() {
		return "securedoors";
	}
}