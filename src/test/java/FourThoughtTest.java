import org.junit.jupiter.api.Test;
import util.AbstractTest;

import javax.script.ScriptException;

/**
 * TODO write documentation
 */
public class FourThoughtTest extends AbstractTest {
	@Test
	public void one() throws Exception {
		runTest(1, new FourThought()::solve);
	}

	@Override
	protected String getDir() {
		return "4thought";
	}
}
