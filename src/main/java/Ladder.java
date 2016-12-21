import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Ladder {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Ladder().solve(in));
	}

	public String solve(Scanner in) {
		int length = in.nextInt();
		int angle = in.nextInt();

		return String.valueOf(Math.round(Math.ceil(1 / Math.sin(Math.toRadians(angle)) * length)));
	}
}
