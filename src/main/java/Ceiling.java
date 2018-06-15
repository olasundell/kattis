import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * TODO write documentation
 */
public class Ceiling {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Ceiling().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		int size = in.nextInt();
		Set<Set<Integer>> treeHashes = new HashSet<>();

		for (int i = 0 ; i < n ; i++) {
			treeHashes.add(createTree(size, in));
		}
		return String.valueOf(treeHashes.size());
	}

	private Set<Integer> createTree(int size, Scanner in) {
		Set<Integer> set = new HashSet<>();

		Node root = new Node(in.nextInt(), 0);

		for (int i = 1 ; i < size ; i++) {
			int val = in.nextInt();
			set.add(addNode(root, val));
		}

		return set;
	}

	private int addNode(Node node, int val) {
		if (node.value > val) {
			if (node.left == null) {
				int index = 2 * node.index + 1;
				node.left = new Node(val, index);
				return index;
			} else {
				return addNode(node.left, val);
			}
		}  else {
			if (node.right == null) {
				int index = 2 * node.index + 2;
				node.right = new Node(val, index);

				return index;
			} else {
				return addNode(node.right, val);
			}
		}
	}

	class Node {
		final int value;
		final int index;
		Node left;
		Node right;

		Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
}
