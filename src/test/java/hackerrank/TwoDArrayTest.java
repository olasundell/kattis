package hackerrank;

import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO write documentation
 */
public class TwoDArrayTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new TwoDArray()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new TwoDArray()::solve);
	}
	@Override
	protected String getDir() {
		return "hackerrank/2d-array-testcases";
	}
}