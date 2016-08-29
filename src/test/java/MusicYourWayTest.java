import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class MusicYourWayTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new MusicYourWay()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new MusicYourWay()::solve);
	}

	@Override
	protected String getDir() {
		return "musicyourway";
	}
}