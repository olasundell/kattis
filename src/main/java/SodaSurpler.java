import java.util.Scanner;

/**
 * TODO write documentation
 */
public class SodaSurpler {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new SodaSurpler().solve(in));
	}

	public String solve(Scanner in) {
		int bottles = in.nextInt();
		bottles += in.nextInt();
		int cost = in.nextInt();
		int drank = 0;

		while (bottles >= cost) {
			drank++;
			bottles -= (cost - 1);
		}

		return String.valueOf(drank);
	}
}
