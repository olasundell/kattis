import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class EnlargingHashTablesTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new EnlargingHashTables()::solve);
	}

	@Override
	protected String getDir() {
		return "enlarginghashtables";
	}
}