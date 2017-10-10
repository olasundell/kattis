import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Incognito {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Incognito().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		List<Integer> results = new ArrayList<>();

		for (int i = 0 ; i < n ; i++) {
			results.add(solveOne(in));
		}
		return results.stream().map(String::valueOf).collect(Collectors.joining("\n"));
	}

	private Integer solveOne(Scanner in) {
		int n = in.nextInt();
		in.nextLine();

		Map<String, Integer> map = new HashMap<>();

		for (int i = 0 ; i < n ; i++) {
			String[] line = in.nextLine().split(" ");
			map.put(line[1], map.getOrDefault(line[1], 0) + 1);
		}

		List<Integer> itemsInCategory = new ArrayList<>(map.values());

		int total = 0;

		for (int i = 1 ; i <= map.size() ; i++) {
			final List<List<Integer>> combine = combine(itemsInCategory.size(), i);
			total += combine.stream()
					.map(k -> sum(k, itemsInCategory))
					.mapToInt(j -> j)
					.sum();
		}

		return total;
	}

	private Integer sum(List<Integer> k, List<Integer> itemsInCategory) {
		int sum = 1;
		for (Integer i: k) {
			sum *= itemsInCategory.get(i - 1);
		}

		return sum;
	}

	private Map<Point, List<List<Integer>>> combinations = new HashMap<>();

	private List<List<Integer>> combine(int n, int k) {
		final Point key = new Point(n, k);
		if (combinations.containsKey(key)) {
			return combinations.get(key);
		}
		List<List<Integer>> result = new ArrayList<>();

		if (n <= 0 || n < k) {
			return result;
		}

		List<Integer> item = new ArrayList<>();
		dfs(n, k, 1, item, result); // because it need to begin from 1

		combinations.put(key, result);

		return result;
	}

	private void dfs(int n, int k, int start, List<Integer> item,
	                 List<List<Integer>> res) {
		if (item.size() == k) {
			res.add(new ArrayList<>(item));
			return;
		}

		for (int i = start; i <= n; i++) {
			item.add(i);
			dfs(n, k, i + 1, item, res);
			item.remove(item.size() - 1);
		}
	}
}
