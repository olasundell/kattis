package hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class StringPrefix {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new StringPrefix().solve(in));
	}

	public String solve(Scanner in) {
		in.nextLine();
		Node root = new Node(' ', false);
		while (in.hasNextLine()) {
			String s = in.nextLine();

			Deque<Character> ts = new ArrayDeque<>();

			for (char c: s.toCharArray()) {
				ts.add(c);
			}

			if (!add(root, ts)) {
				return "BAD SET\n" + s;
			}
		}
		return "GOOD SET";
	}

	private boolean add(Node n, Deque<Character> chars) {
		if (chars.isEmpty()) {
			return true;
		}

		Character c = chars.pollFirst();
		Node child;
		if (n.hasKey(c)) {
			child = n.getChild(c);
			// if the child is the end of a previous string and the current string contains more chars, the old one is a prefix
			if (child.end || chars.isEmpty()) {
				return false;
			}
		} else {
			child = n.addChild(c, chars.isEmpty());
		}

		return add(child, chars);
	}

	private static class Node {
		private final Map<Character, Node> children;
		private final char data;
		private final boolean end;

		public Node(char data, boolean end) {
			this.data = data;
			this.end = end;
			children = new HashMap<>();
		}

		public Node getChild(char c) {
			return children.get(c);
		}

		public boolean hasKey(char c) {
			return children.containsKey(c);
		}

		public Node addChild(char c, boolean end) {
			Node value = new Node(c, end);
			children.put(c, value);
			return value;
		}
	}
}
