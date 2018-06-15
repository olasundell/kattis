import java.util.ArrayList;
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
public class RunningMoM {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new RunningMoM().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		in.nextLine();
		Map<String, Set<String>> graph = new HashMap<>();

		for (int i = 0 ; i < n ; i++) {
			final String[] s = in.nextLine().split(" ");

			graph.computeIfAbsent(s[0], (v) -> new HashSet<>()).add(s[1]);
		}

		List<Result> results = new ArrayList<>();

		while (in.hasNext()) {
			String c = in.next();
			results.add(new Result(c, dfs(graph, c, c, new HashSet<>())));
		}

		return results.stream()
				.map(Result::toString)
				.collect(Collectors.joining("\n"));
	}

	private Boolean dfs(Map<String, Set<String>> graph, String target, String current, Set<String> visited) {
		// we've already been here, remember?
		if (visited.contains(current)) {
			return false;
		}

		// dead end
		if (!graph.containsKey(current)) {
			return false;
		}

		if (target.equals(current)) {
			// if visited is empty, we haven't gone anywhere
			if (!visited.isEmpty()) {
				// yay!
				return true;
			}
		} else {
			// we don't want to add the target to visited cities, lest we'll never find our way back.
//			visited = new HashSet<>(visited);
			visited.add(current);
		}

		final Set<String> strings = graph.get(current);
		strings.removeAll(visited);

		for (String s: strings) {
			if (dfs(graph, target, s, visited)) {
				return true;
			}
		}

		return false;
	}

	class Result {
		final String name;
		final Boolean safe;

		public Result(String name, Boolean safe) {
			this.name = name;
			this.safe = safe;
		}

		@Override
		public String toString() {
			return name + " " + (this.safe ? "safe" : "trapped");
		}
	}
}
