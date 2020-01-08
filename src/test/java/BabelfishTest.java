import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO write documentation
 */
public class BabelfishTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Babelfish()::solve);
	}

	@Override
	protected String getDir() {
		return "babelfish";
	}
}