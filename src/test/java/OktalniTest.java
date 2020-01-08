import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class OktalniTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Oktalni()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new Oktalni()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new Oktalni()::solve);
	}

	@Override
	protected String getDir() {
		return "oktalni";
	}
}