import org.junit.Test;
import util.AbstractTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class SnapperHardTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new SnapperHard()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new SnapperHard()::solve);
	}

//	@Test
	public void writeTestFile() throws IOException {
		// You may assume that 1≤T≤10_000 , 1≤N≤30 and 0≤K≤10^8

		File in = new File("/Users/olasundell/code/kattis/src/test/resources/snapperhard/2.in");
		File ans = new File("/Users/olasundell/code/kattis/src/test/resources/snapperhard/2.ans");
		FileWriter inWriter = new FileWriter(in);

		inWriter.write("10000\n");

		for (int i = 1 ; i <= 10_000 ; i++) {
			inWriter.write(String.format("%d %d\n", 30, 100_000_000));
		}
		inWriter.close();


		FileWriter ansWriter = new FileWriter(ans);
		ansWriter.write("1");
		ansWriter.close();
	}

	@Override
	protected String getDir() {
		return "snapperhard";
	}
}