package hackerrank;

import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class SparseArraysTest extends AbstractTest  {
	@Test
	public void one() throws IOException {
		runTest(1, new SparseArrays()::solve);
	}

	@Override
	protected String getDir() {
		return "hackerrank/sparse-arrays";
	}
}