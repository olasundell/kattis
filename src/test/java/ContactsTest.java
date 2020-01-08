import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * TODO write documentation
 */
public class ContactsTest extends AbstractTest {
	@Test
	public void three() throws IOException {
		runTest(4, new Contacts()::solve);
	}

	@Test
	public void shouldFind() {
		String s = "5\n" +
				           "add foobar\n" +
				           "add foobaz\n" +
				           "add fooxyzzy\n" +
				           "find foo\n" +
				           "find bar\n";
		String result = new Contacts().solve(new Scanner(s));

		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertEquals("3\n0", result);
	}

	@Override
	protected String getDir() {
		return "contacts";
	}
}