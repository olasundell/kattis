import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class KarteTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Karte()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new Karte()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new Karte()::solve);
	}

	@Override
	protected String getDir() {
		return "karte";
	}
}