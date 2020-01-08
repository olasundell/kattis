import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class YodaTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Yoda()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new Yoda()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new Yoda()::solve);
	}

	@Test
	public void four() throws IOException {
		runTest(4, new Yoda()::solve);
	}

	@Test
	public void five() throws IOException {
		runTest(5, new Yoda()::solve);
	}

	@Test
	public void six() throws IOException {
		runTest(6, new Yoda()::solve);
	}

	@Test
	public void seven() throws IOException {
		runTest(7, new Yoda()::solve);
	}
	@Override
	protected String getDir() {
		return "yoda";
	}
}