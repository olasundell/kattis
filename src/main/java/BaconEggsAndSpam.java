import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class BaconEggsAndSpam {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new BaconEggsAndSpam().solve(in));
	}

	public String solve(Scanner in) {
		List<SortedMap<String, SortedSet<String>>> result = new ArrayList<>();

		for (;;) {

			int n = in.nextInt();

			if (n == 0) {
				break;
			}
			in.nextLine();

			SortedMap<String, SortedSet<String>> current = new TreeMap<>();

			for (int i = 0 ; i < n ; i++) {
				String[] p = in.nextLine().split(" ");
				String name = p[0];

				for (int j = 1; j < p.length; j++) {
					if (!current.containsKey(p[j])) {
						current.put(p[j], new TreeSet<>());
					}

					current.get(p[j]).add(name);
				}
			}

			result.add(current);
		}

		// TODO this gives me a headache but it looks kind of cool to the untrained eye. To the trained eye it looks like the mess it really is.
		return result.stream().map(map -> map.entrySet()
						.stream()
						.map(e -> e.getKey() + " " + e.getValue().stream().collect(Collectors.joining(" ")))
						.collect(Collectors.joining("\n")))
				.collect(Collectors.joining("\n\n")) + "\n";
	}
}
