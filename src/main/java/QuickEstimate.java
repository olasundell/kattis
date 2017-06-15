import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class QuickEstimate {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new QuickEstimate().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		in.nextLine();

		List<Integer> results = new ArrayList<>();

		for (int i = 0 ; i < n ; i++) {
			results.add(in.nextLine().length());
		}

		return results.stream()
				.map(String::valueOf)
				.collect(Collectors.joining("\n"));
	}
}
