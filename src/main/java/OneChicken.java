import java.util.Scanner;

/**
 * TODO write documentation
 */
public class OneChicken {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new OneChicken().solve(in));
	}

	public String solve(Scanner in) {
		int a = in.nextInt();
		int b = in.nextInt();
		int sum = b - a;

		StringBuilder builder = new StringBuilder("Dr. Chaz ");

		if (sum > 0) {
			builder.append("will have ")
					.append(sum)
					.append(" piece")
					.append(sum > 1 ? "s" : "")
					.append(" of chicken left over!");
		} else {
			builder.append("needs ")
					.append(-sum)
					.append(" more piece")
					.append(-sum > 1 ? "s" : "")
					.append(" of chicken!");
		}

		return builder.toString();
	}
}
