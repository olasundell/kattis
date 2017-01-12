import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Kitten {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Kitten().solve(in));
	}

	public String solve(Scanner in) {
		int kitten = in.nextInt();
		in.nextLine();

		Map<Integer, Node> nodes = new HashMap<>();
		Map<Integer, Integer> parents = new HashMap<>();

		setup(in, nodes, parents);

		int rootId = findRootId(parents);
		int currentId = kitten;
		List<Integer> path = new ArrayList<>();

		while (currentId != rootId) {
			path.add(currentId);
			currentId = parents.get(currentId);
		}

		path.add(rootId);

		return path.stream().map(String::valueOf).collect(Collectors.joining(" "));
	}

	private int findRootId(Map<Integer, Integer> parents) {
		Optional<Integer> rootId = parents.values().stream()
				.filter(v -> !parents.keySet().contains(v))
				.findFirst();

		return rootId.get();
	}


	private void setup(Scanner in, Map<Integer, Node> nodes, Map<Integer, Integer> parents) {
		while (in.hasNextLine()) {
			String line = in.nextLine();
			if ("-1".equals(line)) {
				break;
			}

			String[] split = line.split(" ");
			Integer parentKey = Integer.valueOf(split[0]);
			Node parent = new Node(parentKey);
			nodes.put(parentKey, parent);

			for (int i = 1 ; i < split.length ; i++) {
				Integer childKey = Integer.valueOf(split[i]);
				Node child = new Node(childKey);
				parent.addChild(child);
				parents.put(childKey, parentKey);
			}
		}
	}

	private static class Node {
		private final Integer value;
		private final List<Node> children;

		public Node(Integer value) {
			this.value = value;
			this.children = new ArrayList<>();
		}

		public void addChild(Node n) {
			children.add(n);
		}
	}
}
