import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO write documentation
 */
public class DiceCupTest extends AbstractTest {
//	@Test
	public void mask() {
		for (int i = 0 ; i < 36 ; i++) {
			int i1 = (i / 1) % 6 + 1;
			int i2 = (i / 6) % 6 + 1;
			System.err.println(i1 + " " + i2);
		}
	}
	@Test
	public void one() throws IOException {
		runTest(1, new DiceCup()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new DiceCup()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new DiceCup()::solve);
	}

	@Override
	protected String getDir() {
		return "dicecup";
	}
}