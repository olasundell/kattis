import java.util.Scanner;

/**
 * TODO write documentation
 */
public class GrassSeed {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new GrassSeed().solve(in));
	}

	public String solve(Scanner in) {
		double price = in.nextDouble();
		in.nextLine();

		int n = in.nextInt();
		in.nextLine();

		double area = 0;

		for (int i = 0 ; i < n ; i++) {
			area += in.nextDouble() * in.nextDouble();
		}

		return String.format("%.7f", area * price);
	}
}
