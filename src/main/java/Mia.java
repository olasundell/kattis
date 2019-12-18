import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Mia is a dice game for two players. Each roll consist of two dice. Mia involves bluffing about what a player has rolled, but in this problem we focus only on its scoring rules. Unlike most other dice games, the score of a roll is not simply the sum of the dice.
 Instead, a roll is scored as follows:

 Mia (12 or 21 ) is always highest.
 Next come doubles (11 , 22 , and so on). Ties are broken by value, with 66 being highest.
 All remaining rolls are sorted such that the highest number comes first, which results in a two-digit number.
 The value of the roll is the value of that number, e.g. 3 and 4 becomes 43.
 */
public class Mia {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Mia().solve(in));
	}

	public String solve(Scanner in) {
		List<String> results = new ArrayList<>();
		for (;;) {
			PlayerThrow one = new PlayerThrow(in.nextInt(), in.nextInt());
			PlayerThrow two = new PlayerThrow(in.nextInt(), in.nextInt());

			int playerWon;

			if (one.value() == 0) {
				break;
			}

			if (one.value() == two.value()) {
				results.add("Tie.");
			} else {
				if (one.value() > two.value()) {
					playerWon = 1;
				} else {
					playerWon = 2;
				}

				results.add("kattis.Player " + playerWon + " wins.");
			}
		}

		return results.stream().collect(Collectors.joining("\n"));
	}

	class PlayerThrow {
		final int max;
		final int min;

		public PlayerThrow(int first, int second) {
			this.max = Math.max(first, second);
			this.min = Math.min(first, second);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}

			PlayerThrow that = (PlayerThrow) o;

			if (max != that.max) {
				return false;
			}

			return min == that.min;
		}

		int value() {
			if (max == 2 && min == 1) {
				return 1000;
			}

			if (max == min) {
				return max * 100 + min * 10;
			}

			return max * 10 + min;
		}
	}
}
