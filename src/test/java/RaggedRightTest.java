import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class RaggedRightTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new RaggedRight()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new RaggedRight()::solve);
	}

	@Override
	protected String getDir() {
		return "raggedright";
	}
}