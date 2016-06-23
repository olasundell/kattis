import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class DetailedDifferencesTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new DetailedDifferences()::solve);
	}

	@Override
	protected String getDir() {
		return "detaileddifferences";
	}
}