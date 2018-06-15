import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class DrmMessagesTest extends AbstractTest  {
	@Test
	public void one() throws IOException {
		runTest(1, new DrmMessages()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new DrmMessages()::solve);
	}

	@Override
	protected String getDir() {
		return "drmmessages";
	}
}