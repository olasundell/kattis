import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Contacts {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Contacts().solve(in));
	}

	public String solve(Scanner in) {
		Trie root = new Trie(Character.MIN_VALUE, false);
		List<Integer> result = new ArrayList<>();

		int n = in.nextInt();

		for (int i = 0 ; i < n ; i++) {
			String verb = in.next();
			String noun = in.next();
			Deque<Character> nounQ = new ArrayDeque<>();

			for (char c: noun.toCharArray()) {
				nounQ.add(c);
			}

			switch (verb) {
			case "add":
				add(root, nounQ);
				break;
			case "find":
				result.add(find(root, nounQ));
				break;
			}
		}

		return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
	}

	int find(Trie node, Deque<Character> word) {
		if (word.isEmpty()) {
			return node.subs;
		}

		if (!node.children.containsKey(word.peekFirst())) {
			return 0;
		}

		return find(node.children.get(word.pollFirst()), word);
	}

	int count(Trie node) {
		if (node.children.isEmpty()) {
			return 1;
		}

		int sum = node.children.values()
				          .stream()
				          .mapToInt(this::count)
				          .sum();

		if (node.terminated) {
			sum++;
		}

		return sum;
	}

	void add(Trie node, Deque<Character> word) {
		if (word.isEmpty()) {
			return;
		}

		Optional<Trie> possibleChild = node.children.values()
				                               .stream()
				                               .filter(c -> c.value == word.peekFirst())
				                               .findFirst();

		// TODO clean up
		if (possibleChild.isPresent()) {
			word.pollFirst();
			Trie node1 = possibleChild.get();

			node1.subs++;
			add(node1, word);
		} else {
			Trie e = new Trie(word.pollFirst(), word.isEmpty());
			node.children.put(e.value, e);
			add(e, word);
		}
	}

	static class Trie {
		Map<Character, Trie> children = new HashMap<>();
		final char value;
		int subs = 1;
		final boolean terminated;

		public Trie(char value, boolean terminated) {
			this.value = value;
			this.terminated = terminated;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Trie trie = (Trie) o;

			return value == trie.value;

		}

		@Override
		public int hashCode() {
			return (int) value;
		}
	}
}
