import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;
import java.util.HashMap;

/**
 * TODO write documentation
 */
public class MetaprogrammingTest extends AbstractTest {
	private Metaprogramming metaprogramming;
	private HashMap<String, Integer> defines;

	@Before
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

		Assert.assertEquals(expected, result);
	}

	@Test
	public void evalShouldReturnTrue() {
		String actual = metaprogramming.eval("eval f > g", defines);

		Assert.assertEquals("true", actual);
	}

	@Test
	public void evalShouldReturnFalse() {
		String actual = metaprogramming.eval("eval f < g", defines);

		Assert.assertEquals("false", actual);
	}

	@Test
	public void evalShouldReturnUndefined() {
		String actual = metaprogramming.eval("eval q > g", defines);

		Assert.assertEquals("undefined", actual);
	}

	@Override
	protected String getDir() {
		return "metaprogramming";
	}
}