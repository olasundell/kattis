import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO write documentation
 */
public class FaktorTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Faktor()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new Faktor()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new Faktor()::solve);
	}

	@Override
	protected String getDir() {
		return "faktor";
	}
}