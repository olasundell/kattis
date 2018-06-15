import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class TouchScreenKeyboard {
	private final char[] row1 = "qwertyuiop".toCharArray();
	private final char[] row2 = "asdfghjkl".toCharArray();
	private final char[] row3 = "zxcvbnm".toCharArray();
	private final char[][] rows = { row1, row2, row3 };

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new TouchScreenKeyboard().solve(in));
	}

	public String solve(Scanner in) {
		Map<Character, Map<Character, Integer>> distances = buildDistances();
		List<PriorityQueue<Result>> allResults = new ArrayList<>();

		int n = in.nextInt();

		for (int i = 0 ; i < n ; i++) {
			PriorityQueue<Result> currentResults = new PriorityQueue<>();
			String correct = in.next();
			int cases = in.nextInt();

			for (int j = 0 ; j < cases ; j++) {
				String word = in.next();
				currentResults.add(new Result(calcDistance(distances, correct, word), word));
			}

			allResults.add(currentResults);
		}

		return allResults.stream()
				.map(q -> q.stream()
						.sorted()
						.map(Result::toString)
						.collect(Collectors.joining("\n")))
				.collect(Collectors.joining("\n"));
	}

	private Integer calcDistance(Map<Character, Map<Character, Integer>> distances, String correct, String word) {
		int total = 0;

		final char[] chars = word.toCharArray();
		final char[] correctChars = correct.toCharArray();

		for (int i = 0 ; i < chars.length ; i++) {
			total += distances.get(correctChars[i]).get(chars[i]);
		}

		return total;
	}

	private class Result implements Comparable<Result> {
		final Integer n;
		final String w;

		public Result(Integer n, String w) {
			this.n = n;
			this.w = w;
		}

		@Override
		public int compareTo(Result o) {
			if (o.n.equals(this.n)) {
				return this.w.compareTo(o.w);
			}

			return this.n.compareTo(o.n);
		}

		@Override
		public String toString() {
			return w + " " + n;
		}
	}

	private Map<Character, Map<Character, Integer>> buildDistances() {
		final Map<Character, Map<Character, Integer>> map = new HashMap<>();

		for (int i = 0 ; i < rows.length ; i++) {
			for (int j = 0 ; j < rows[i].length ; j++) {
				Character currentC = rows[i][j];
				Map<Character, Integer> charMap = new HashMap<>();

				for (int k = 0 ; k < rows.length ; k++) {
					for (int l = 0; l < rows[k].length; l++) {
						Character c = rows[k][l];
						charMap.put(c, Math.abs(i - k) + Math.abs(j - l));
					}
				}

				map.put(currentC, charMap);
			}
		}

		return map;
	}
}
