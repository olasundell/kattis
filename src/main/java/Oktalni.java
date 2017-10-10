import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Oktalni {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Oktalni().solve(in));
	}

	public String solve(Scanner in) {
		String num = in.next();

		StringBuilder builder = new StringBuilder();
		for (int i = num.length() ; i > 0 ;) {
			String nm;

			if (i >= 3) {
				nm = num.substring(i - 3, i);
				i -= 3;
			} else {
				nm = num.substring(0, i);
				// ie, break. But not yet, we want to append first
				i = -1;
			}

			final Integer integer = Integer.valueOf(nm, 2);
			builder.insert(0, integer.intValue());
		}

		return builder.toString();
	}
}
