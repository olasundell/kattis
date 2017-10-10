import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class IncognitoTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Incognito()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new Incognito()::solve);
	}

	@Override
	protected String getDir() {
		return "incognito";
	}
}