import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class FallingApart {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new FallingApart().solve(in));
	}

	public String solve(Scanner in) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
		int n = in.nextInt();

		for (int i = 0 ; i < n ; i++) {
			queue.add(in.nextInt());
		}

		int one = 0;
		int two = 0;

		for (int i = 0 ; !queue.isEmpty() ; i++) {
			int number = queue.remove();
			if (i % 2 == 0) {
				one += number;
			} else {
				two += number;
			}
		}
		return one + " " + two;
	}
}
