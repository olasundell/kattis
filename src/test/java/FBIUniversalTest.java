import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO write documentation
 */
public class FBIUniversalTest extends AbstractTest  {
	@Test
	public void one() throws IOException {
		runTest(1, new FBIUniversal()::solve);
	}

	@Override
	protected String getDir() {
		return "fbiuniversal";
	}
}