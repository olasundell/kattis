import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Skocimis {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Skocimis().solve(in));
	}

	public String solve(Scanner in) {
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();

		return String.valueOf(Math.max(b - a, c - b) - 1);
	}
}
