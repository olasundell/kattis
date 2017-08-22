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

	public void writeTestFile() throws IOException {
		writeToFile("vending", 3, fileWriter -> {
		fileWriter.write("100000\n");

		for (int i = 1 ; i <= 100_000 ; i++) {
			fileWriter.write(String.format("%d %d %d %d\n", i, 1, 1_000_000, 1_000_000));
		}
		}, fileWriter -> {
			fileWriter.write("1");
		});
	}

	@Override
	protected String getDir() {
		return "vending";
	}
}