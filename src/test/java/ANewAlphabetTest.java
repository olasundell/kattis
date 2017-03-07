import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class ANewAlphabetTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new ANewAlphabet()::solve);
	}
	@Test
	public void two() throws IOException {
		runTest(2, new ANewAlphabet()::solve);
	}
	@Test
	public void three() throws IOException {
		runTest(3, new ANewAlphabet()::solve);
	}

	@Override
	protected String getDir() {
		return "anewalphabet";
	}
}