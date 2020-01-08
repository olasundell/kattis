import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO write documentation
 */
public class R2Test extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new R2()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new R2()::solve);
	}

	@Override
	protected String getDir() {
		return "R2";
	}
}