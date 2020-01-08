package hackerrank;

import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO write documentation
 */
public class DynamicArrayTest extends AbstractTest  {
	@Test
	public void ten() throws IOException {
		runTest(10, new DynamicArray()::solve);
	}

	@Override
	protected String getDir() {
		return "hackerrank/dynamic-array-testcases";
	}
}