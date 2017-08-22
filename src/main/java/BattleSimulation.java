import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * TODO write documentation
 */
public class BattleSimulation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new BattleSimulation().solve(in));
	}

	public String solve(Scanner in) {
		return in.nextLine().replaceAll("(RBL|RLB|BRL|LRB|LBR|BLR)", "C") //.replaceAll("RLB", "C")
//				.replaceAll("BRL", "C").replaceAll("LRB", "C")
//				.replaceAll("LBR", "C").replaceAll("BLR", "C")
				.replaceAll("R", "S").replaceAll("B", "K").replaceAll("L", "H");
//		return stateMachine(in);
	}

	private String stateMachine(Scanner in) {
		final char NONE = ' ';
		String line = in.next();
		StringBuilder builder = new StringBuilder();

		char previous = NONE;
		char current = NONE;
		char next;

		final char[] chars = line.toCharArray();
		for (int i = 0 ; i < chars.length ; i++) {
			previous = current;
			current = chars[i];

			// finished
			if (i == chars.length - 1) {
				builder.append(current);
			} else if (previous == current) {
				builder.append(previous);
				builder.append(previous);
			}

			next = chars[i + 1];

			if (next != current && next != previous) {
				builder.append("C");
			}
		}

		return builder.toString();
	}
}
