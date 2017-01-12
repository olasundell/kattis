package hackerrank;

import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class ArraysTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new ArraysAssign()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new ArraysAssign()::solve);
	}

	@Test
	public void foo() {
		Integer.valueOf("abc");
	}
	@Override
	protected String getDir() {
		return "hackerrank/arrays";
	}
}