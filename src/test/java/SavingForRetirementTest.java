import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class SavingForRetirementTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new SavingForRetirement()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new SavingForRetirement()::solve);
	}

	@Override
	protected String getDir() {
		return "savingforretirement";
	}
}