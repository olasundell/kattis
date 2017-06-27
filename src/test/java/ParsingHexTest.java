import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class ParsingHexTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new ParsingHex()::solve);
	}

	@Override
	protected String getDir() {
		return "parsinghex";
	}
}