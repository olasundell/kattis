
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class AnotherCandies {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new AnotherCandies().solve(in));
	}

	public String solve(Scanner in) {
		in.nextLine();
		List<Boolean> result = new ArrayList<>();
		BigInteger sum = BigInteger.valueOf(0);
		int n = 0;

		while (in.hasNextLine()) {
			String s = in.nextLine();
			if (s.isEmpty()) {
				if (n != 0) {
					result.add(Objects.equals(sum.mod(BigInteger.valueOf(n)), BigInteger.ZERO));
					sum = BigInteger.ZERO;
					n = 0;
				}
				// remove number of children, we'll calculate it ourselves anyway.
				in.nextLine();
				continue;
			}

			sum = sum.add(new BigInteger(s));
			n++;
		}

		// final test case
		BigInteger mod = sum.mod(BigInteger.valueOf(n));
		result.add(Objects.equals(mod, BigInteger.ZERO));
		return result.stream().map(b -> b ? "YES" : "NO").collect(Collectors.joining("\n"));
	}
}
