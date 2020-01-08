package hackerrank;

import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class JourneyToTheMoonTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new JourneyToTheMoon()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new JourneyToTheMoon()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new JourneyToTheMoon()::solve);
	}

	@Test
	public void four() throws IOException {
		runTest(4, new JourneyToTheMoon()::solve);
	}

	@Test
	public void eleven() throws IOException {
		runTest(11, new JourneyToTheMoon()::solve);
	}

	@Override
	protected String getDir() {
		return "hackerrank/journeytothemoon";
	}
}