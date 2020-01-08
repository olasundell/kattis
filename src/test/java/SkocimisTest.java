import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO write documentation
 */
public class SkocimisTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Skocimis()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new Skocimis()::solve);
	}

	@Override
	protected String getDir() {
		return "skocimis";
	}
}