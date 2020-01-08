import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * TODO write documentation
 */
public class SumKindOfProblemTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new SumKindOfProblem()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new SumKindOfProblem()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new SumKindOfProblem()::solve);
	}

//	@Test
	public void writeToFile() throws IOException {
		File in = new File("/tmp/3.in");
		BufferedWriter inWriter = new BufferedWriter(new FileWriter(in));
		File ans = new File("/tmp/3.ans");
		BufferedWriter ansWriter = new BufferedWriter(new FileWriter(ans));

		inWriter.write("10000\n");

		for (int i = 1 ; i <= 10_000 ; i++) {
			inWriter.write(i + " " + i + "\n");
			ansWriter.write(i + " 50005000 100000000 100010000\n");
		}

		inWriter.close();
		ansWriter.close();
	}

	@Override
	protected String getDir() {
		return "sumkindofproblem";
	}
}