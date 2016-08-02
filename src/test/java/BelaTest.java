import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class BelaTest extends AbstractTest {

	private Bela bela;

	@Before
	public void setUp() throws Exception {
		bela = new Bela();
	}

	@Test
	public void one() throws IOException {
		runTest(1, bela::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, bela::solve);
	}

	@Test
	public void shouldParseLine() {
		bela.parseLine("AS", 'S');
	}

	@Override
	protected String getDir() {
		return "bela";
	}
}