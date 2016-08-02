import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class EngineeringEnglish {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new EngineeringEnglish().solve(in));
	}

	public String solve(Scanner in) {
		Set<String> words = new HashSet<>();
		List<String> results = new ArrayList<>();

		while (in.hasNextLine()) {
			results.add(Arrays.stream(in.nextLine().split(" "))
					.map(w -> {
						if (words.contains(w.toLowerCase())) {
							return ".";
						} else {
							words.add(w.toLowerCase());
							return w;
						}
					})
					.collect(Collectors.joining(" ")));
		}

		return results.stream().collect(Collectors.joining("\n"));
	}
}
