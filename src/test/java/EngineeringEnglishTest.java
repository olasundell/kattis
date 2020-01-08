import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class EngineeringEnglishTest extends AbstractTest {
	@Test
	public void zero() throws IOException {
		runTest(0, new EngineeringEnglish()::solve);
	}

	@Test
	public void one() throws IOException {
		runTest(1, new EngineeringEnglish()::solve);
	}

	@Override
	protected String getDir() {
		return "engineeringenglish";
	}
}