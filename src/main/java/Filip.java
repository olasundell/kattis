import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Filip {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Filip().solve(in));
	}

	public String solve(Scanner in) {
		int one = Integer.valueOf(new StringBuilder(in.next()).reverse().toString());
		int two = Integer.valueOf(new StringBuilder(in.next()).reverse().toString());
		return String.valueOf(Math.max(one, two));
	}
}
