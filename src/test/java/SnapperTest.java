import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * TODO write documentation
 */
public class SnapperTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Snapper()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new Snapper()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new Snapper()::solve);
	}

//	@Test
	public void writeFile() throws IOException {
		File f = new File("3.in");
		FileWriter fw = new FileWriter(f);

		Random random = new Random(0);

		fw.write("10000\n");
		for (int i = 0 ; i < 10000 ; i++) {
			fw.write(1 + random.nextInt(30) + " " + random.nextInt(Integer.MAX_VALUE - 1) + "\n");
		}

		fw.close();
	}

	@Override
	protected String getDir() {
		return "snappereasy";
	}
}