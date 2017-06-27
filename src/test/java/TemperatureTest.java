import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class TemperatureTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Temperature()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new Temperature()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new Temperature()::solve);
	}

	@Test
	public void four() throws IOException {
		runTest(4, new Temperature()::solve);
	}

	@Test
	public void five() throws IOException {
		runTest(5, new Temperature()::solve);
	}

	@Override
	protected String getDir() {
		return "temperature";
	}
}