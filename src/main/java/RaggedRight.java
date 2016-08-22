import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class RaggedRight {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new RaggedRight().solve(in));
	}

	public String solve(Scanner in) {
		List<Integer> lineLengths = new ArrayList<>();
		int longest = Integer.MIN_VALUE;

		while (in.hasNextLine()) {
			String line = in.nextLine();
			if (line.length() > longest) {
				longest = line.length();
			}

			lineLengths.add(line.length());
		}

		final int finallyLongest = longest;

		return String.valueOf(lineLengths.stream()
				.limit(lineLengths.size() - 1)
				.mapToInt(len -> (finallyLongest - len) * (finallyLongest - len))
				.sum());
	}
}
