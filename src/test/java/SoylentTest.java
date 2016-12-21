import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class SoylentTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Soylent()::solve);
	}

	@Override
	protected String getDir() {
		return "soylent";
	}
}