import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class OddGnome {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new OddGnome().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		in.nextLine();
		List<Integer> kings = new ArrayList<>();

		for (int i = 0 ; i < n ; i++) {
			String line = in.nextLine();
			String[] split = line.split(" ");
			kings.add(findKing(split));
		}

		return kings.stream().map(String::valueOf).collect(Collectors.joining("\n"));
	}

	private Integer findKing(String[] split) {
		if (split.length == 3) {
			return 2;
		}

		int x = Integer.valueOf(split[1]) - 1;

		for (int i = 2 ; i < split.length ; i++) {
			if (Integer.valueOf(split[i]) != i + x) {
				return i;
			}
		}

		return -1;
	}
}
