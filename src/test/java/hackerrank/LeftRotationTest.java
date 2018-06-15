package hackerrank;

import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class LeftRotationTest extends AbstractTest  {
	@Test
	public void one() throws IOException {
		runTest(1, new LeftRotation()::solve);
	}

	@Override
	protected String getDir() {
		return "hackerrank/left-rotation";
	}
}