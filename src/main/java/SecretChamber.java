import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class SecretChamber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new SecretChamber().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		int v = in.nextInt();
		Map<Character, Set<Character>> translations = new HashMap<>();

		for (int i = 0 ; i < n ; i++) {
			String from = in.next();
			String to = in.next();

			translations.computeIfAbsent(from.toCharArray()[0], (k) -> new HashSet<>())
					.add(to.toCharArray()[0]);
		}

		List<String> results = new ArrayList<>();

		for (int i = 0 ; i < v ; i++) {
			char[] from = in.next().toCharArray();
			char[] to = in.next().toCharArray();

			if (from.length != to.length) {
				results.add("no");
			} else {
				boolean equal = true;

				for (int j = 0; j < from.length; j++) {
					if (!isTranslateable(translations, from[j], to[j], new HashSet<>())) {
						equal = false;
					}
				}

				results.add(equal ? "yes" : "no");
			}
		}

		return results.stream().collect(Collectors.joining("\n"));
	}

	private boolean isTranslateable(Map<Character, Set<Character>> translations,
	                                char from,
	                                char to,
	                                Set<Character> visited) {
		if (from == to) {
			return true;
		}

		if (visited.contains(from)) {
			return false;
		}

		visited.add(from);

		final Set<Character> set = translations.getOrDefault(from, Collections.emptySet());

		if (set.contains(to)) {
			return true;
		}

		for (char c: set) {
			if (isTranslateable(translations, c, to, visited)) {
				return true;
			}
		}

		return false;
	}
}
