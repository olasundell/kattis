import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Backspace {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Backspace().solve(in));
	}

	public String solve(Scanner in) {
		StringBuilder builder = new StringBuilder();
		String line = in.nextLine();

		for (char c: line.toCharArray()) {
			if (c == '<') {
				builder.deleteCharAt(Math.max(builder.length() - 1, 0));
			} else {
				builder.append(c);
			}
		}

		return builder.toString();
	}
}
