import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class GuessTheDataStructureTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new GuessTheDataStructure()::solve);
	}

	@Override
	protected String getDir() {
		return "guessthedatastructure";
	}
}