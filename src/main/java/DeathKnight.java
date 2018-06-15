import java.util.Scanner;

/**
 * TODO write documentation
 */
public class DeathKnight {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new DeathKnight().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		int successful = 0;

		for (int i = 0 ; i < n ; i++) {
			final String s = in.next();
			if (!s.contains("CD")) {
				successful++;
			}
		}

		return String.valueOf(successful);
	}
}
