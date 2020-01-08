import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO write documentation
 */
public class StickySituationTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new StickySituation()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new StickySituation()::solve);
	}

	@Override
	protected String getDir() {
		return "stickysituation";
	}
}