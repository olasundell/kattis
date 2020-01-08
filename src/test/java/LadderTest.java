import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO write documentation
 */

public class LadderTest extends AbstractTest {
	@Test
	public void zero() throws IOException {
		runTest(0, new Ladder()::solve);
	}

	@Test
	public void one() throws IOException {
		runTest(1, new Ladder()::solve);
	}

	@Override
	protected String getDir() {
		return "ladder";
	}
}