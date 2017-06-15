import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class SumKindOfProblem {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new SumKindOfProblem().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
//		Map<Integer, Integer> positive = new HashMap<>();
//		Map<Integer, Integer> odd = new HashMap<>();
//		Map<Integer, Integer> even = new HashMap<>();
		Map<Integer, String> cache = new HashMap<>();

		int p = 0;
		int o = 0;
		int e = 0;

		for (int j = 1 ; j <= 10_000 ; j++) {
			p += j;
//			positive.put(j, p);

			o += 2 * (j - 1) + 1;
//			odd.put(j, o);

			// apparently 0 isn't in the list of the first even integers
			e += 2 * j;
			cache.put(j, String.format("%d %d %d", p, o, e));
		}
		List<String> results = new ArrayList<>();

		for (int i = 0 ; i < n ; i++) {
			final int i1 = in.nextInt();
			int size = in.nextInt();
//			String s = cache.computeIfAbsent(size, s1 -> );

			results.add(String.format("%d %s", i1, cache.get(size)));
		}
//		return result.toString();

		return results.stream().collect(Collectors.joining("\n"));

//		Map<Integer, List<Integer>> sums = new HashMap<>();
//
//		for (int i = 0 ; i < n ; i++) {
//			final ArrayList<Integer> value = new ArrayList<>();
//			sums.put(in.nextInt(), value);
//			int size = in.nextInt();
//
//			value.add(positive.get(size));
//			value.add(odd.get(size));
//			value.add(even.get(size));
//		}

//		return createResponseString(sums);
	}

//	private String createResponseString(Map<Integer, List<Integer>> sums) {
//		final SortedSet<Map.Entry<Integer, List<Integer>>> entries = new TreeSet<>(Comparator.comparing(Map.Entry::getKey, Comparator.naturalOrder()));
//		entries.addAll(sums.entrySet());
//
//		return entries.stream()
//				.map(e -> String.format("%d %s", e.getKey(), e.getValue().stream().map(String::valueOf).collect(Collectors.joining(" "))))
//				.collect(Collectors.joining("\n"));
//	}
}
