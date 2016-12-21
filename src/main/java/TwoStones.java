import java.util.Scanner;

/**
 * TODO write documentation
 */
public class TwoStones {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new TwoStones().solve(in));
	}

	public String solve(Scanner in) {
		if (in.nextInt() % 2 == 0) {
			return "Bob";
		} else {
			return "Alice";
		}
	}
}
