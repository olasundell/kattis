package hackerrank;

import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class MigratoryBirdsTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new MigratoryBirds()::solve);
	}

	@Test
	public void four() throws IOException {
		runTest(4, new MigratoryBirds()::solve);
	}

	@Override
	protected String getDir() {
		return "hackerrank/migratory-birds";
	}
}