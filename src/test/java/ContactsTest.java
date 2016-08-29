import org.junit.Assert;
import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;
import java.util.Scanner;

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

		Assert.assertNotNull(result);
		Assert.assertFalse(result.isEmpty());
		Assert.assertEquals("3\n0", result);
	}

	@Override
	protected String getDir() {
		return "contacts";
	}
}