import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class EncodedMessageTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new EncodedMessage()::solve);
	}

	@Override
	protected String getDir() {
		return "encodedmessage";
	}
}