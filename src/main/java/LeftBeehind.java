import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class LeftBeehind {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new LeftBeehind().solve(in));
	}

	public String solve(Scanner in) {
		List<String> result = new ArrayList<>();

		for (;;) {
			int sweet = in.nextInt();
			int sour = in.nextInt();

			if (sweet + sour == 0) {
				break;
			} else if (sweet + sour == 13) {
				result.add("Never speak again.");
			} else if (sweet > sour) {
				result.add("To the convention.");
			} else if (sweet < sour) {
				result.add("Left beehind.");
			} else {
				result.add("Undecided.");
			}
		}

		return result.stream().collect(Collectors.joining("\n"));
	}
}
