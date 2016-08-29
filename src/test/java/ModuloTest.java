import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class ModuloTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Modulo()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new Modulo()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new Modulo()::solve);
	}

	@Override
	protected String getDir() {
		return "modulo";
	}
}