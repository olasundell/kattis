package juryjeopardy;

import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class JuryJeopardyTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new JuryJeopardy()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new JuryJeopardy()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new JuryJeopardy()::solve);
	}

	@Test
	public void four() throws IOException {
		runTest(4, new JuryJeopardy()::solve);
	}

	@Override
	protected String getDir() {
		return "juryjeopardy";
	}
}