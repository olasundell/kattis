import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class KittenTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Kitten()::solve);
	}

	@Override
	protected String getDir() {
		return "kitten";
	}
}