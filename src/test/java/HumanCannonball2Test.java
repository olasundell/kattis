import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class HumanCannonball2Test extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new HumanCannonball2()::solve);
	}

	@Override
	protected String getDir() {
		return "humancannonball2";
	}
}