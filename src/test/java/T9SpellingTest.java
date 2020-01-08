import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class T9SpellingTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new T9Spelling()::solve);
	}

	@Override
	protected String getDir() {
		return "t9spelling";
	}
}