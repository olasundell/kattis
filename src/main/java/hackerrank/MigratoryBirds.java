package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class MigratoryBirds {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new MigratoryBirds().solve(in));
	}

	public String solve(Scanner in) {
		Map<Integer, Bird> birds = new HashMap<>();

		for (int i = 1 ; i <= 5 ; i++) {
			Bird b = new Bird(i);
			birds.put(i, b);
		}
		int n = in.nextInt();
		for (int i = 0 ; i < n ; i++) {
			birds.get(in.nextInt()).num++;
		}

		PriorityQueue<Bird> sorted = new PriorityQueue<>((o1, o2) -> {
			if (o1.num == o2.num) {
				return o1.id - o2.id;
			} else {
				return o2.num - o1.num;
			}
		});

		sorted.addAll(birds.values());

		return String.valueOf(sorted.peek().id);
	}

	private static class Bird {
		final int id;
		int num;

		private Bird(int id) {
			this.id = id;
		}
	}
}
