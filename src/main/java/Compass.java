import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Compass {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Compass().solve(in));
	}

	public String solve(Scanner in) {
		int current = in.nextInt();
		int correct = in.nextInt();

		int diff = correct - current;

		if (diff > 180) {
			diff -= 360;
		}

		if (diff <= -180) {
			diff += 360;
		}

		return String.valueOf(diff);
	}
}
