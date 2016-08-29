import org.junit.Test;
import util.AbstractTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * TODO write documentation
 */
public class PhoneListTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new PhoneList()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new PhoneList()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new PhoneList()::solve);
	}

	@Test
	public void four() throws IOException {
		runTest(4, new PhoneList()::solve);
	}

	@Test
	public void five() throws IOException {
		runTest(5, new PhoneList()::solve);
	}

	@Test
	public void six() throws IOException {
		runTest(6, new PhoneList()::solve);
	}

//	@Test
	public void write() throws IOException {
		File f = new File("src/test/resources/phonelist/4.in");
		FileWriter fw = new FileWriter(f);
		Random random = new Random(0);

		fw.write("40\n");

		for (int i = 0 ; i < 40 ; i++) {
			fw.write("10000\n");
			for (int j = 0 ; j < 10_000 ; j++) {
				fw.write(String.valueOf(random.nextInt(9_999_999)) + "\n");
			}
		}

		fw.close();
	}

	@Override
	protected String getDir() {
		return "phonelist";
	}
}