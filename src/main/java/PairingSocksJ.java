import java.util.LinkedList;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class PairingSocksJ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new PairingSocksJ().solve(in));
	}

	public String solve(Scanner in) {
		in.nextLine();
		LinkedList<Integer> socks = new LinkedList<>();

		int moves = 0;
		while (in.hasNextInt()) {
			moves++;
			final int i = in.nextInt();
			if (!socks.isEmpty() && socks.getFirst().equals(i)) {
				socks.removeFirst();
			} else {
				socks.addFirst(i);
			}
		}

		if (socks.isEmpty()) {
			return String.valueOf(moves);
		} else {
			return "impossible";
		}
	}
}
