import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class PhoneList {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new PhoneList().solve(in));
	}

	public String solve(Scanner in) {
		int n = Integer.valueOf(in.nextLine());

		List<Boolean> results = new ArrayList<>();

		for (int i = 0 ; i < n ; i++) {
			results.add(solveList(in));
		}

		return results.stream()
				.map(b -> b ? "YES" : "NO")
				.collect(Collectors.joining("\n"));
	}

	private boolean solveList(Scanner in) {
		int n = Integer.valueOf(in.nextLine());
		Trie root = new Trie();

		for (int i = 0 ; i < n ; i++) {
			Trie current = root;
			String line = "";
			// let's see if the error is here
			if (in.hasNextLine()) {
				line = in.nextLine();
			} else {
				return false;
			}
			for (int j = 0 ; j < line.length() ; j++) {
				int value = Integer.valueOf(line.substring(j, j+1));

				if (current.children.containsKey(value)) {
					current = current.children.get(value);
					if (current.end && j < line.length()) {
						return false;
					}
				} else {
					Trie t = new Trie(value, j == line.length() - 1);
					current.children.put(value, t);
					current = t;
				}
			}
		}

		return true;
	}

	protected static class Trie {
		Map<Integer, Trie> children = new HashMap<>();
		boolean end = false;
		int value;

		public Trie() {}

		public Trie(int value, boolean end) {
			this.value = value;
			this.end = end;
		}
	}
}
