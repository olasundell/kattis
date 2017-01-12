import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class GeneticSearch {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new GeneticSearch().solve(in));
	}

	public String solve(Scanner in) {
		List<String> results = new ArrayList<>();

		while (in.hasNextLine()) {
			String search = in.next();
			if ("0".equals(search)) {
				break;
			}

			String line = in.next();

			results.add(String.format("%d %d %d", noChange(search, line),
					oneRemoved(search, line),
					randomChar(search, line)));
			System.err.println();

			in.nextLine();
		}
		return results.stream().collect(Collectors.joining("\n"));
	}

	private int noChange(String search, String line) {
		int idx = 0;
		int instances = 0;

		while ((idx = line.indexOf(search, idx)) >= 0) {
			instances++;
			idx++;
			if (line.length() <= idx) {
				break;
			}
		}

		return instances;
	}

	private int oneRemoved(String search, String line) {
		int count = 0;
		Set<String> mods = new HashSet<>();
		for (int i = 0 ; i < search.length() ; i++) {
			String s = new String(search.substring(0, i) + search.substring(i + 1, search.length()));
			if (!mods.contains(s)) {
				count += noChange(s, line);
				mods.add(s);
			}
		}

		return count;
	}

	private int randomChar(String search, String line) {
		int count = 0;
		Set<String> mods = new HashSet<>();

		for (int i = 0 ; i <= search.length() ; i++) {
			for (char c: new char[] {'A', 'G', 'C', 'T'}) {
				String s = new String(search.substring(0, i) +
						c +
						search.substring(i, search.length()));
				if (!mods.contains(s)) {
					count += noChange(s, line);
					mods.add(s);
				}
			}
		}

		return count;
	}
}
