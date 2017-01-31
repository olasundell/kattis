import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class StickySituation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new StickySituation().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();

		PriorityQueue<Long> queue = new PriorityQueue<>();

		for (int i = 0 ; i < n ; i++) {
			queue.add(in.nextLong());
		}

		long p1 = queue.poll();
		long p2 = queue.poll();

		while (!queue.isEmpty()) {
			long current = queue.poll();
			if (p1 + p2 > current) {
				return "possible";
			}
			p1 = p2;
			p2 = current;
		}

		return "impossible";
	}
}
