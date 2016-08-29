import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;
import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class AnotherCandiesTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new AnotherCandies()::solve);
	}

	@Test
	public void shouldAddStuff() {
		List<String> candies = new ArrayList<>();
		Random random = new Random(0);

		long i1 = Long.MAX_VALUE;

		for (int j = 0 ; j < 20 ; j++) {
			BigInteger bigInteger = BigInteger.ZERO;

			candies.add("");

			for (int i = 0; i < 20_000; i++) {
				BigInteger candy = BigInteger.valueOf(Math.abs(random.nextLong() % i1));
				candies.add(candy.toString());
				bigInteger = bigInteger.add(candy);
			}
		}

		String source = candies.stream().collect(Collectors.joining("\n"));
		Instant before = Instant.now();
		new AnotherCandies().solve(new Scanner(source));
		Instant after = Instant.now();

		System.out.println(Duration.between(before, after).toMillis());
	}
	@Override
	protected String getDir() {
		return "anothercandies";
	}
}