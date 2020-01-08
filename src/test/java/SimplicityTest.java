import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO write documentation
 */
public class SimplicityTest extends AbstractTest {
	@Test
	public void zero() throws IOException {
		runTest(0, new Simplicity()::solve);
	}

	@Test
	public void one() throws IOException {
		runTest(1, new Simplicity()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new Simplicity()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new Simplicity()::solve);
	}

	@Test
	public void four() throws IOException {
		runTest(4, new Simplicity()::solve);
	}

	@Test
	public void five() throws IOException {
		runTest(5, new Simplicity()::solve);
	}

	@Test
	public void six() throws IOException {
		runTest(6, new Simplicity()::solve);
	}

	@Override
	protected String getDir() {
		return "simplicity";
	}
}