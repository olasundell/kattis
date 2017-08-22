import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class BattleSimulationTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new BattleSimulation()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new BattleSimulation()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new BattleSimulation()::solve);
	}

	@Test
	public void four() throws IOException {
		runTest(4, new BattleSimulation()::solve);
	}

//	@Test
	public void writeFile() throws IOException {
		writeToFile("battlesimulation", 4, safeWriter -> {
			Random random = new Random(0);

			StringBuilder builder = new StringBuilder();

			for (int i = 0 ; i < 1_000_000 ; i++) {
				switch (random.nextInt(3)) {
					case 0:
						builder.append('R');
						break;
					case 1:
						builder.append('B');
						break;
					case 2:
						builder.append('L');
						break;
				}
			}
			safeWriter.write(builder.toString());
		}, safeWriter -> safeWriter.write("C"));
	}

	@Override
	protected String getDir() {
		return "battlesimulation";
	}
}