import org.junit.Test;
import util.AbstractTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class VendingTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Vending()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new Vending()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new Vending()::solve);
	}

//	@Test
	public void writeToFile() throws IOException {
		File in = new File("/Users/olasundell/code/kattis/src/test/resources/vending/4.in");
		File ans = new File("/Users/olasundell/code/kattis/src/test/resources/vending/4.ans");
		FileWriter inWriter = new FileWriter(in);

		inWriter.write("100000\n");

		for (int i = 1 ; i <= 100_000 ; i++) {
			inWriter.write(String.format("%d %d %d %d\n", i, 1, 1_000_000, 1_000_000));
		}
		inWriter.close();


		FileWriter ansWriter = new FileWriter(ans);
		ansWriter.write("1");
		ansWriter.close();
	}

	@Override
	protected String getDir() {
		return "vending";
	}
}