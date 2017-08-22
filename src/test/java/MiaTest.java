import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class MiaTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Mia()::solve);
	}

	@Override
	protected String getDir() {
		return "mia";
	}
}