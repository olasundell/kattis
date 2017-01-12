package hackerrank;

import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class LinkedListsTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new LinkedLists()::solve);
	}

	@Test
	public void four() throws IOException {
		runTest(4, new LinkedLists()::solve);
	}

	@Override
	protected String getDir() {
		return "hackerrank/linkedlists";
	}
}