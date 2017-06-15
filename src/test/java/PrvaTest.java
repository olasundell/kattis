import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;
import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class PrvaTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Prva()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new Prva()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new Prva()::solve);
	}

	@Override
	protected String getDir() {
		return "prva";
	}
}