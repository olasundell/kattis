import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * TODO write documentation
 */
public class MetaprogrammingTest extends AbstractTest {
	private Metaprogramming metaprogramming;
	private HashMap<String, Integer> defines;

	@BeforeEach
	public void setUp() throws Exception {
		metaprogramming = new Metaprogramming();
		defines = new HashMap<String, Integer>(){{
			put("f", 3);
			put("g", 2);
		}};
	}

	@Test
	public void one() throws IOException {
		runTest(1, metaprogramming::solve);
	}

	@Test
	public void getKeyShouldWork() {
		String expected = "I looove  cheese";
		String value = "123";
		String result = metaprogramming.getKey("define " + value + " " + expected, value);

		assertEquals(expected, result);
	}

	@Test
	public void evalShouldReturnTrue() {
		String actual = metaprogramming.eval("eval f > g", defines);

		assertEquals("true", actual);
	}

	@Test
	public void evalShouldReturnFalse() {
		String actual = metaprogramming.eval("eval f < g", defines);

		assertEquals("false", actual);
	}

	@Test
	public void evalShouldReturnUndefined() {
		String actual = metaprogramming.eval("eval q > g", defines);

		assertEquals("undefined", actual);
	}

	@Override
	protected String getDir() {
		return "metaprogramming";
	}
}