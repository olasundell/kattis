import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

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