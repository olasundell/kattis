import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class NastyHacksTest extends AbstractTest  {
	@Test
	public void one() throws IOException {
		runTest(1, new NastyHacks()::solve);
	}

	@Override
	protected String getDir() {
		return "nastyhacks";
	}
}