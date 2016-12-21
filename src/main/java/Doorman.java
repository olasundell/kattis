import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
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
		int current = 0;
		int count = 0;
		Deque<Character> characters = new ArrayDeque<>();

		String line = in.next();
		for (char c: line.toCharArray()) {
			characters.add(c);
		}

		while (!characters.isEmpty()) {
			current += sign(characters.pollFirst());

			if (current > max || current < -max) {
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
