import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO write documentation
 */
public class MastermindTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new Mastermind()::solve);
	}

	@Test
	public void four() throws IOException {
		runTest(4, new Mastermind()::solve);
	}

	static List<Long> c = new ArrayList<>();

/*	@Test
	public void primeCalc() {
		List<Integer> primes = new ArrayList<>();

		for (int i = 3 ; i <= 536_870_912 ; i += 2) {
			if (new BigInteger(String.valueOf(i)).isProbablePrime(15)) {
				System.out.println(i + " is a prime!");
			}
//			if (isNotPrime(primes, i)) {
//				System.out.println(i + " is not a prime");
//				continue;
//			}
//
//			System.out.println(i + " IS a prime");
//			primes.add(i);
		}

		primes.add(2);
	}*/

	private boolean isNotPrime(List<Integer> primes, int i) {
		int sqrt = (int) Math.sqrt(i);
		for (int p: primes) {
			if (p > sqrt) {
				return false;
			}

			if (i % p == 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected String getDir() {
		return "mastermind";
	}
}