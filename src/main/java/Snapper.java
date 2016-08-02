import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Snapper {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Snapper().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		in.nextLine();
		List<String> results = new ArrayList<>();

		for (int i = 1 ; i <= n ; i++) {
			int shift = in.nextInt();
			int num = in.nextInt();

			int mask = (2 << shift - 1) - 1;
			int masked = num & mask;

			boolean v = masked == mask;

			String format = String.format("Case #%d: %s", i, v ? "ON" : "OFF");
			results.add(format);
		}

		return results.stream().collect(Collectors.joining("\n"));
	}
}
