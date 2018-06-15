package hackerrank;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class CakeCandles {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new CakeCandles().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

		for (int i = 0 ; i < n ; i++) {
			queue.offer(in.nextInt());
		}

		Integer m = queue.poll();
		Integer num = 1;

		if (m == null) {
			return "0";
		}

		while (m.equals(queue.poll())) {
			num++;
		}

		return String.valueOf(num);
	}
}
