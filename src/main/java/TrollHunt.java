import java.util.Scanner;

/**
 * TODO write documentation
 */
public class TrollHunt {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new TrollHunt().solve(in));
	}

	public String solve(Scanner in) {
		int bridges = in.nextInt() - 1;
		int knights = in.nextInt();
		int groupSize = in.nextInt();

		int groups = knights / groupSize;

		int days = bridges / groups;

		if (bridges % groups > 0) {
			days++;
		}

		return String.valueOf(days);
	}
}
