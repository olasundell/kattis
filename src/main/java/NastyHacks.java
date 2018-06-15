import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class NastyHacks {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new NastyHacks().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		List<String> results = new ArrayList<>();

		for (int i = 0 ; i < n ; i++) {
			int noAd = in.nextInt();
			int ad = in.nextInt();
			int cost = in.nextInt();

			results.add(calc(noAd, ad, cost));
		}

		return results.stream().collect(Collectors.joining("\n"));
	}

	private String calc(int noAd, int ad, int cost) {
		if (noAd == ad - cost) {
			return "does not matter";
		}

		if (noAd > ad - cost) {
			return "do not advertise";
		}

		return "advertise";
	}
}
