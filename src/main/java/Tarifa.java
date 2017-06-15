import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Tarifa {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Tarifa().solve(in));
	}

	public String solve(Scanner in) {
		int x = in.nextInt();
		int currentX = 0;
		int n = in.nextInt();

		for (int i = 0 ; i < n ; i++) {
			currentX += x;
			currentX -= in.nextInt();
		}

		return String.valueOf(currentX + x);
	}
}
