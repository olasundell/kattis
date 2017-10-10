import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *  We’ll assume that all ASCII characters from ! up to and including * are special.
 *  Also, characters from [ up to and including ] are considered special.
 */
public class TheBackslashProblem {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new TheBackslashProblem().solve(in));
	}

	public String solve(Scanner in) {
		List<String> results = new ArrayList<>();

		while (in.hasNextLine()) {
			results.add(escape(in));
		}
		return results.stream().collect(Collectors.joining("\n"));
	}

	private String escape(Scanner in) {
		int n = in.nextInt();
		in.nextLine();
		char[] chars = in.nextLine().toCharArray();

		for (int i = 0 ; i < n ; i++) {
			StringBuilder builder = new StringBuilder();
			for (char c: chars) {
				if ((c >= '!' && c <= '*') || (c >= '[' && c <= ']')) {
					builder.append("\\");
				}
				builder.append(c);
			}
			chars = builder.toString().toCharArray();
		}

		return new String(chars);
	}
}
