import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Soylent {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Soylent().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		List<String> results = new ArrayList<>();

		for (int i = 0 ; i < n ; i++) {
			int cal = in.nextInt();
			int r = cal / 400;
			if (cal % 400 > 0) {
				r++;
			}

			results.add(String.valueOf(r));
		}

		return results.stream().collect(Collectors.joining("\n"));
	}
}
