import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class EnlargingHashTables {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new EnlargingHashTables().solve(in));
	}

	public String solve(Scanner in) {
		String s;
		List<String> results = new ArrayList<>();

		while (in.hasNextLine()) {
			s = in.nextLine();
			if ("0".equals(s)) {
				break;
			}

			BigInteger num = new BigInteger(s);
			StringBuilder resultBuilder = new StringBuilder();

			BigInteger min = num.shiftLeft(1);

			while (!min.isProbablePrime(15)) {
				min = min.add(BigInteger.ONE);
			}

			resultBuilder.append(min);

			if (!num.isProbablePrime(15)) {
				resultBuilder.append(" (").append(s).append(" is not prime)");
			}
			results.add(resultBuilder.toString());
		}

		return results.stream().collect(Collectors.joining("\n"));
	}
}
