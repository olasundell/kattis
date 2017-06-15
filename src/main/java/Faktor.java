import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Faktor {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Faktor().solve(in));
	}

	public String solve(Scanner in) {
		int a = in.nextInt();
		int b = in.nextInt();

		return String.valueOf(a * (b -1) + 1);
	}
}
