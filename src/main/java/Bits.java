import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Bits {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Bits().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		in.nextLine();
		List<Integer> results = new ArrayList<>();

		for (int i = 0 ; i < n ; i++) {
			char[] chars = in.nextLine().toCharArray();

			int max = Integer.MIN_VALUE;

			StringBuilder builder = new StringBuilder();

			for (char c: chars) {
				builder.append(c);
				int count = Integer.toBinaryString(Integer.valueOf(builder.toString())).replaceAll("0", "").length();
				if (max < count) {
					max = count;
				}
			}

			results.add(max);
		}

		return results.stream().map(String::valueOf).collect(Collectors.joining("\n"));
	}
}
