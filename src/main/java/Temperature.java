import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Temperature {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Temperature().solve(in));
	}

	/*
		Input consists of two space-separated integers, X and Y.
		X is the point on B where A is zero.
		Y is the number of degrees in B that equal a change of a single degree in A.

		Output the temperature where both scales are the same.
		This number must have an absolute or relative error of at most 10−6.
		If no such temperature exists, output “IMPOSSIBLE” (without the quotes) instead.
		If more than one such point exists, output “ALL GOOD” (without the quotes) instead.
	 */

	public String solve(Scanner in) {
		double m = in.nextInt();
		double k = in.nextInt();

		if (k == 1) {
			if (m != 0) {
				return "IMPOSSIBLE";
			} else {
				return "ALL GOOD";
			}
		}

		double x = (-m) / (k -1);
		double y = k * x + m;

		if (Math.floor(y) == y) {
			return String.valueOf((long)y);
		}

		return String.format("%.9f", y);
	}
}
