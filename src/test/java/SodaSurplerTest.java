import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO write documentation
 */
public class SodaSurplerTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new SodaSurpler()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new SodaSurpler()::solve);
	}

	@Override
	protected String getDir() {
		return "sodasurpler";
	}
}