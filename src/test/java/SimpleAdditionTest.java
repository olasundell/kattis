import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class SimpleAdditionTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new SimpleAddition()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new SimpleAddition()::solve);
	}

	@Override
	protected String getDir() {
		return "simpleaddition";
	}
}