package juryjeopardy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * TODO write documentation
 */
public class JuryJeopardyTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new JuryJeopardy()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new JuryJeopardy()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new JuryJeopardy()::solve);
	}

	@Test
	public void four() throws IOException {
		runTest(4, new JuryJeopardy()::solve);
	}

	@Test
	public void five() throws IOException {
		runTest(5, new JuryJeopardy()::solve);
	}

	@Test
	public void six() throws IOException {
		runTest(6, new JuryJeopardy()::solve);
	}

	@Test
	public void seven() throws IOException {
		runTest(7, new JuryJeopardy()::solve);
	}

	@Test
	public void eight() {
		StringBuilder builder = new StringBuilder();

		for (int i = 0 ; i < 100 ; i++) {
			builder.append("F");
		}
		builder.append("R");

		for (int j = 0 ; j < 100 ; j++) {
			for (int i = 1; i < 100_000; i++) {
				builder.append("F");
			}
			if (j % 2 == 0) {
				builder.append("R");
				builder.append("R");
			} else {
				builder.append("L");
				builder.append("L");
			}
		}

		String s = new JuryJeopardy().solve(new Scanner(builder.toString()));

		assertNotNull(s);
	}

	@Override
	protected String getDir() {
		return "juryjeopardy";
	}
}