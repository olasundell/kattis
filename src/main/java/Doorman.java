import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Doorman {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Doorman().solve(in));
	}

	public String solve(Scanner in) {
		int max = in.nextInt();
		int diff = 0;
		int count = 0;
		Deque<Character> characters = new ArrayDeque<>();

		String line = in.next();
		for (char c: line.toCharArray()) {
			characters.add(c);
		}

		while (!characters.isEmpty()) {
			diff += sign(characters.pollFirst());
			if (Math.abs(diff) > max) {
				// the next person's gender might differ from the current person's.
				if (Math.abs(sign(characters.peekFirst()) + diff) <= max) {
					diff += sign(characters.pollFirst());
					count++;
				} else {
					// the next person in line is of the same gender as the person held back
					return String.valueOf(count);
				}
			}

			count++;
		}

		return String.valueOf(count);
	}

	private String oldSolve(Scanner in) {
		int max = in.nextInt();
		int current = 0;
		int count = 0;
		Deque<Character> characters = new ArrayDeque<>();

		String line = in.next();
		for (char c: line.toCharArray()) {
			characters.add(c);
		}

		while (!characters.isEmpty()) {
			current += sign(characters.pollFirst());

			if (Math.abs(current) > max) {
				int sign = sign(characters.peekFirst());
				float signum = Math.signum(current);

				if (!characters.isEmpty() && sign + signum == 0) {
					characters.pollFirst();
					count++;
				} else {
					break;
				}
			}

			count++;
		}
		return String.valueOf(count);
	}

	public int sign(char c) {
		switch (c) {
			case 'M':
				return -1;
			case 'W':
				return 1;
		}
		return 0;
	}
}
