import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class HidingPlacesTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new HidingPlaces()::solve);
	}

	@Override
	protected String getDir() {
		return "hidingplaces";
	}
}