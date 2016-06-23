import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class JustAMinuteTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new JustAMinute()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new JustAMinute()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new JustAMinute()::solve);
	}

	@Override
	protected String getDir() {
		return "justaminute";
	}
}